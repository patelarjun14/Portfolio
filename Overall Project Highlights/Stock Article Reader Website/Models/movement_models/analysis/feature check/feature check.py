'''
This file analyzes the features and how important they are to train our models.
We discovered that all features are the same in importance. This is due to 
the complexity of price movement
'''

# Import the following
import pandas as pd
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.feature_extraction.text import TfidfVectorizer
import os
import joblib
from sklearn.preprocessing import LabelEncoder
from sklearn.linear_model import LogisticRegression
from sklearn.feature_selection import RFECV

# Load data from database.xlsx
print("Loading data from database.xlsx")
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'database.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Here we want to define our features by text, numerical, and categorical
# all need to be converted to integer in order for our model to use it
text_features = ['title', 'summary', 'text', 'authors']
numerical_features = [
    'overall_sentiment_score', 
    'relevance_score',
    'Blockchain', 
    'Earnings', 
    'IPO', 
    'Mergers & Acquisitions', 
    'Financial Markets',
    'Energy & Transportation', 
    'Finance', 
    'Life Sciences', 
    'Manufacturing',
    'Real Estate & Construction', 
    'Retail & Wholesale', 
    'Technology',
    'date'
]
categorical_columns = ['stock', 'source_domain']

# Now its time to clean out our data

# Remove any NA's
print("Removing rows with NA values")
df = df.dropna()

# IMPORTANT: Shuffle data. We discovered if we are training models and sort by date,
# the data becomes imbalanced 
print("Shuffling data")
df = df.sample(frac=1, random_state=42)

# Remove any articles with less than 1000 characters
# Remove any empty summaries
print("Cleaning out text and summary")
df = df[df['text'].str.replace(r'\s', '').str.len() > 1000]
df = df[df['summary'].str.strip() != '']

# Add price movement as target
print("Adding price movement")
df['price_movement'] = (df['article_price_close_stock'].shift(-1) > df['article_price_close_stock']).astype(int)

# Convert data into month for better analysis
print("Converting Date to month")
df['Date'] = pd.to_datetime(df['Date'])
df['month'] = df['Date'].dt.month
df = df.drop(['Date'], axis=1)

# Remove rows where open and close prices for articles are the same
# IMPORTANT: We want to pick articles that actually shifted. Also some articles that 
# come out on friday and saturday will have same prices
print("Removing articles with same open and close price")
balanced_df = df[df['article_price_open_stock'] != df['article_price_close_stock']]

# Pick 5000 instances for each class
# This will help ensure that our data is balanced
# Data has been shuffled so we will have randomly selected 10,000 for each
print("Balancing data")
positive_instances = df[df['price_movement'] == 1].head(10000)
negative_instances = df[df['price_movement'] == 0].head(10000)

# Combine the data into a balanced df
print("Combining data")
balanced_df = pd.concat([positive_instances, negative_instances], ignore_index=True)

# Keep the original summary and text columns for reference
print("Saving references")
balanced_df['original_summary'] = balanced_df['summary']
balanced_df['original_text'] = balanced_df['text']

# Drop unnecessary columns
print("Dropping useless data")
balanced_df = balanced_df.drop(['article_price_open_spy',
                                'article_price_close_spy',
                                'article_price_open_stock',
                                'article_price_close_stock',
                                'url',
                                'time_published',
                                'source',
                                ], axis=1)

# Encode categorical columns
print("Encoding categorical columns")
label_encoder = LabelEncoder()
for categorical_column in categorical_columns:
    balanced_df[categorical_column] = label_encoder.fit_transform(balanced_df[categorical_column])

# Create two dictionaries. One to save text feature values during vectorizing
# the other to save our vectorizers 
text_feature_summary_columns = {}
vectorizers = {}

# Iterate through text features
for text_feature in text_features:
    print(f"Vectorizing {text_feature}")
    
    # IMPORTANT: We cant just input the vectorizer into one column. If we vectorize 
    # it will create too many features. If we do this, we will be having one feature for 
    # each word and our goal here is to understand what features help our model the most. We want to
    # create a positive vectorizer that is trained on positive instances and a negative
    # vectorizer on negative instances so that we can score words and score the entire 
    # text feature and make it an integer

    # Train TfidfVectorizer on positive instances
    # use stop words to cut out unnecessary words
    positive_vectorizer = TfidfVectorizer(
        max_features = 500,
        stop_words='english'
    )

    # Fit the vectorizer on positive instances for text feautre
    # save vectorizer in dictionary 
    positive_X = positive_vectorizer.fit_transform(positive_instances[text_feature])
    vectorizers[f'{text_feature}_positive_vectorizer'] = positive_vectorizer

    # Train TfidfVectorizer on negative instances
    # use stop words to cut out unnecessary words
    negative_vectorizer = TfidfVectorizer(
        max_features= 500,
        stop_words='english'
    )
    
    # Fit the vectorizer on positive instances for text feautre
    # save vectorizer in dictionary 
    negative_X = negative_vectorizer.fit_transform(negative_instances[text_feature])
    vectorizers[f'{text_feature}_negative_vectorizer'] = negative_vectorizer

    # Score each text and convert it into an integer by adding the weights 
    # of the positive and negative words then conver this into a column
    text_feature_values = []
    for text in balanced_df[text_feature]:
        total_weight = 0
        for word in text.split():
            if word in positive_vectorizer.vocabulary_:
                total_weight += positive_vectorizer.idf_[positive_vectorizer.vocabulary_[word]]
            if word in negative_vectorizer.vocabulary_:
                total_weight -= negative_vectorizer.idf_[negative_vectorizer.vocabulary_[word]]
        text_feature_values.append(total_weight)
    
    text_feature_summary_columns[text_feature] = text_feature_values

print("COMPLETED")

# Create new columns for text_feature_summary_columns
for text_feature, text_feature_values in text_feature_summary_columns.items():
    balanced_df[f'{text_feature}_summary'] = text_feature_values

# Drop the original text features
# We have the originals saved in another column
balanced_df = balanced_df.drop(text_features, axis=1)


# Create X and y for training
X = balanced_df[numerical_features + [f'{text_feature}_summary' for text_feature in text_features]]
y = balanced_df['price_movement']

# Save the cleaned and combined df
file_path = os.path.join(script_dir, 'cleaned_combined_df.xlsx')
balanced_df.to_excel(file_path, index=False)

# Save the vectorizers
for key, vectorizer in vectorizers.items():
    file_path = os.path.join(script_dir, f'{key}_vectorizer.joblib')
    joblib.dump(vectorizer, file_path)

# Check the shape of X_train and y before splitting
print("Shape of X_numerical:", X.shape)
print("Shape of y:", y.shape)

# IMPORTANT: Here we did not organize by date because we just want a undestanding
# of what important features there are if any. As mentioned above, we discovered 
# there wasnt any important features and that all of them were equal. This also shows
# how not organizing by date can improve accuracy 

# Split the data into training and testing sets
print("Splitting data")
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a base model
base_model = LogisticRegression()

# Recursive Feature Elimination with Cross-Validation
# https://scikit-learn.org/stable/modules/generated/sklearn.feature_selection.RFECV.html
rfecv = RFECV(estimator=base_model, cv=5)

# Fit RFECV to training data
rfecv.fit(X_train, y_train)

# Get the selected feature indices
selected_feature_indices = rfecv.support_

# Get the names of the selected features
selected_features = X_train.columns[selected_feature_indices]

# Train a model with the selected features
selected_model = LogisticRegression()
selected_model.fit(X_train[selected_features], y_train)

# Save the best model with selected features
file_path = os.path.join(script_dir, 'best_model.joblib')
joblib.dump(selected_model, file_path)

# Save the selected features in order of importance
selected_features_df = pd.DataFrame({'Features': selected_features, 'Rankings': rfecv.ranking_})
file_path = os.path.join(script_dir, 'selected_features.xlsx')
selected_features_df.to_excel(file_path, index=False)

# Evaluate the model performance using cross-validation
print("Evaluating model performance")
cv_scores = cross_val_score(selected_model, X_train[selected_features], y_train, cv=5)

# Print the selected features and cross-validation scores
print("Selected Features:")
print(selected_features_df)
print("Cross-validation scores:", cv_scores)
print("Mean CV score:", cv_scores.mean())

'''
Selected Features:
                      Features  Rankings
0      overall_sentiment_score         1
1              relevance_score         1
2                   Blockchain         1
3                     Earnings         1
4                          IPO         1
5       Mergers & Acquisitions         1
6            Financial Markets         1
7      Energy & Transportation         1
8                      Finance         1
9                Life Sciences         1
10               Manufacturing         1
11  Real Estate & Construction         1
12          Retail & Wholesale         1
13                  Technology         1
14                       month         1
15               title_summary         1
16             summary_summary         1
17                text_summary         1
18             authors_summary         1
Cross-validation scores: [0.549375  0.5575    0.5715625 0.55875   0.5578125]
Mean CV score: 0.5589999999999999
'''