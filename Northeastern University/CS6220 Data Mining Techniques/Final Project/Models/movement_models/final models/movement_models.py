'''
This code contains our final movement models 
'''

# Import the following
import pandas as pd
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import accuracy_score, classification_report
from sklearn.pipeline import Pipeline
import os
import joblib
import matplotlib.pyplot as plt
import spacy

# Store current directory 
current_dir = os.path.abspath(os.path.dirname(__file__))

# Create function to save model
def save_model(model, vectorizer, accuracy, filename_prefix):
    vectorizer_file = os.path.join(current_dir, f'{filename_prefix}_vectorizer.joblib')
    joblib.dump(vectorizer, vectorizer_file)
    model_file = os.path.join(current_dir, f'{filename_prefix}_model_accuracy_{accuracy:.2f}.joblib')
    joblib.dump(model, model_file)
    print(f"Model and vectorizer saved")

# Create function to train model
def train_model(pipeline, param_grid, X_train, y_train, X_test, y_test, vectorizer, model_name):
    grid_search = GridSearchCV(pipeline, param_grid, cv=3, scoring='accuracy', n_jobs=-1, verbose=2)
    grid_search.fit(X_train, y_train)
    best_params = grid_search.best_params_
    print(f"Best parameters for {model_name}:", best_params)
    best_model = grid_search.best_estimator_[f'{model_name.lower()}']    
    y_pred = best_model.predict(X_test)    
    accuracy = accuracy_score(y_test, y_pred)
    print(f"Accuracy for {model_name}: {accuracy:.2f}")    
    print(f"Classification Report ({model_name} Model):\n", classification_report(y_test, y_pred))    
    save_model(best_model, vectorizer, accuracy, model_name)


# Get data from database
print("Loading data from database.xlsx")
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'database.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Create groups for features
text_features = ['title', 'summary', 'text', 'authors']
numerical_features = [
    'overall_sentiment_score', 'relevance_score',
    'Blockchain', 'Earnings', 'IPO', 'Mergers & Acquisitions', 'Financial Markets',
    'Energy & Transportation', 'Finance', 'Life Sciences', 'Manufacturing',
    'Real Estate & Construction', 'Retail & Wholesale', 'Technology'
]
categorical_columns = ['stock', 'source_domain']

# Remove any NA
print("Removing rows with NA values")
df = df.dropna()

# Shuffle Data
print("Shuffling the data...")
df = df.sample(frac=1, random_state=42)

# Clean out data
print("Cleaning out text and summary")
df = df[df['text'].str.replace(r'\s', '').str.len() > 1000]
df = df[df['summary'].str.strip() != '']

# Add price movement as target
print("Adding price movement")
df['price_movement'] = (df['article_price_close_stock'].shift(-1) > df['article_price_close_stock']).astype(int)

# Remove any articles that didnt move the price
print("Removing articles with the same open and close price")
balanced_df = df[df['article_price_open_stock'] != df['article_price_close_stock']]

# Balance data
print("Balancing data")
positive_instances = df[df['price_movement'] == 1].head(5000)
negative_instances = df[df['price_movement'] == 0].head(5000)
balanced_df = pd.concat([positive_instances, negative_instances], ignore_index=True)

# Save references
print("Saving references")
balanced_df['original_summary'] = balanced_df['summary'].copy()
balanced_df['original_text'] = balanced_df['text'].copy()

# Drop any useless data
print("Dropping useless data")
balanced_df = balanced_df.drop(['article_price_open_spy',
                                'article_price_close_spy',
                                'article_price_open_stock',
                                'article_price_close_stock',
                                'url',
                                'time_published',
                                'source',
                                ], axis=1)

# Encode columns
print("Encoding categorical columns")
label_encoder = LabelEncoder()
for categorical_column in categorical_columns:
    balanced_df[categorical_column] = label_encoder.fit_transform(balanced_df[categorical_column])

# Use spacy. This will help us select the best words to put weights on in vectorizing 
nlp = spacy.load("en_core_web_sm")
spacy_summary = []
count = 0
for text in balanced_df['text']:
    print(f"On row {count}")
    tokens = nlp(text)
    selected_tokens = [token.text for token in tokens if token.pos_ in {'VERB', 'ADJ', 'ADV', 'NOUN', 'ADP'}]
    spacy_summary.append(" ".join(selected_tokens))
    count += 1

# Create new Column
balanced_df['text_spacy'] = spacy_summary

# Sort by date and save file
sorted_df = balanced_df.sort_values(by='Date')
file_path = os.path.join(current_dir, 'sorted_data.xlsx')
sorted_df.to_excel(file_path, index=False)

# Split data
train_df, test_df = train_test_split(sorted_df, test_size=0.2, shuffle=False)

# Use text spacy to train our model
X_train_text, X_test_text = train_df['text_spacy'], test_df['text_spacy']
y_train_movement, y_test_movement = train_df['price_movement'], test_df['price_movement']

# Select max_features and take out stop words
vectorizer = TfidfVectorizer(max_features=500, stop_words='english')

# Vectorize using spacy data
X_train_summary_vectorized = vectorizer.fit_transform(X_train_text)

# Transform using spacy data
X_train_text_vectorized = vectorizer.transform(X_train_text)
X_test_text_vectorized = vectorizer.transform(X_test_text)

# Create grid search

# Best parameters for LogisticRegression: {'logisticregression__C': 1.5, 'logisticregression__max_iter': 50, 'logisticregression__penalty': 'l2'}
lr_param_grid = {
    'logisticregression__C': [0.01, 0.05, .1, .5, 1, 1.5],
    'logisticregression__penalty': ['l1','l2', None],
    'logisticregression__max_iter': [50, 100, 200, 300]

}


# Best parameters for randomforestclassifier: {'randomforestclassifier__max_depth': None, 'randomforestclassifier__min_samples_split': 15, 'randomforestclassifier__n_estimators': 500}
rf_param_grid = {
    'randomforestclassifier__n_estimators': [300, 400, 500],
    'randomforestclassifier__max_depth': [None, 40, 60, 80],
    'randomforestclassifier__min_samples_split': [5, 10, 15]
}

# Best parameters for gradientboostingclassifier: {'gradientboostingclassifier__learning_rate': 1, 'gradientboostingclassifier__max_depth': 2, 'gradientboostingclassifier__n_estimators': 30}
gb_param_grid = {
    'gradientboostingclassifier__n_estimators': [30, 40, 50],
    'gradientboostingclassifier__learning_rate': [0.01, 1, 1.5],
    'gradientboostingclassifier__max_depth': [2, 5, 10]
}

knn_param_grid = {
    'kneighborsclassifier__n_neighbors': [5, 10, 15],
    'kneighborsclassifier__algorithm': ['auto', 'ball_tree', 'kd_tree', 'brute'],
    'kneighborsclassifier__leaf_size': [10, 30, 50],
}

# Create models
lr_model = LogisticRegression()
rf_model = RandomForestClassifier()
gb_model = GradientBoostingClassifier()
knn_model = KNeighborsClassifier()

# Create pipelines
lr_pipeline = Pipeline([('logisticregression', lr_model)])
rf_pipeline = Pipeline([('randomforestclassifier', rf_model)])
gb_pipeline = Pipeline([('gradientboostingclassifier', gb_model)])
knn_pipeline = Pipeline([('kneighborsclassifier', knn_model)])


# Parameters
##################
# 1. pipeline
# 2. x train
# 3. y train
# 4. x test
# 5. y test
# 6. vectorizer
# 7. Name of model
'''
train_model(lr_pipeline, 
            lr_param_grid, 

            X_train_text_vectorized,
              y_train_movement, 

              X_test_text_vectorized, 
              y_test_movement, 

              vectorizer, 
              'LogisticRegression')
'''
'''
train_model(rf_pipeline, 
            rf_param_grid, 

            X_train_text_vectorized, 
            y_train_movement, 

            X_test_text_vectorized, 
            y_test_movement, 

            vectorizer, 
            'randomforestclassifier')


train_model(gb_pipeline, 
            gb_param_grid, 

            X_train_text_vectorized, 
            y_train_movement, 

            X_test_text_vectorized, 
            y_test_movement, 

            vectorizer, 
            'gradientboostingclassifier')
'''

train_model(knn_pipeline, 
            knn_param_grid, 

            X_train_text_vectorized, 
            y_train_movement, 

            X_test_text_vectorized, 
            y_test_movement, vectorizer, 

            'kneighborsclassifier')


"""
Here if its 4k support, that means we did a 80/20 split of 20k datapoints.
We also tested these with 5000 max features 

5000 max features
Best parameters for LogisticRegression: {'logisticregression__C': 0.5, 'logisticregression__max_iter': 50, 'logisticregression__penalty': 'l2'}
Accuracy for LogisticRegression: 0.54
Classification Report (LogisticRegression Model):
               precision    recall  f1-score   support

           0       0.57      0.54      0.55      2097
           1       0.52      0.55      0.54      1903

    accuracy                           0.54      4000
   macro avg       0.54      0.54      0.54      4000
weighted avg       0.55      0.54      0.54      4000

5000 max features
Best parameters for randomforestclassifier: {'randomforestclassifier__max_depth': None, 'randomforestclassifier__min_samples_split': 15, 'randomforestclassifier__n_estimators': 500}
Accuracy for randomforestclassifier: 0.55
Classification Report (randomforestclassifier Model):
               precision    recall  f1-score   support

           0       0.58      0.53      0.55      2097
           1       0.53      0.58      0.55      1903

    accuracy                           0.55      4000
   macro avg       0.55      0.55      0.55      4000
weighted avg       0.55      0.55      0.55      4000

Testing on 500 max features 
Best parameters for gradientboostingclassifier: {'gradientboostingclassifier__learning_rate': 1, 'gradientboostingclassifier__max_depth': 2, 'gradientboostingclassifier__n_estimators': 30}
Accuracy for gradientboostingclassifier: 0.54
Classification Report (gradientboostingclassifier Model):
               precision    recall  f1-score   support

           0       0.56      0.56      0.56      2097
           1       0.51      0.51      0.51      1903

    accuracy                           0.54      4000
   macro avg       0.53      0.53      0.53      4000
weighted avg       0.54      0.54      0.54      4000


Could only run 10k rows of data on this due to runtime (Takes 5.5 hours to run)
Also only used 500 max features 
Best parameters for kneighborsclassifier: {'kneighborsclassifier__algorithm': 'auto', 'kneighborsclassifier__leaf_size': 10, 'kneighborsclassifier__n_neighbors': 15}
Accuracy for kneighborsclassifier: 0.51
Classification Report (kneighborsclassifier Model):
               precision    recall  f1-score   support

           0       0.54      0.49      0.51      1054
           1       0.49      0.54      0.51       946

    accuracy                           0.51      2000
   macro avg       0.52      0.52      0.51      2000
weighted avg       0.52      0.51      0.51      2000

Model and vectorizer saved


"""