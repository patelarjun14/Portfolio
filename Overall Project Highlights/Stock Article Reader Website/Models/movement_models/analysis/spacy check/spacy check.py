'''
This file uses spacy, which is a pre-trained model, to only select
specific grammatical structures to filter out unneccessary words.
We want to use this to see if we can improve the accuracy of our model
'''

# Import the following
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report
import os
from sklearn.preprocessing import LabelEncoder
import spacy
from sklearn.feature_extraction.text import TfidfVectorizer
import joblib
import matplotlib.pyplot as plt

# Load the spacy model
# https://spacy.io/usage/models
spacy_model = spacy.load("en_core_web_sm")

# Load data from database
print("Loading data database")
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'database.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Define text feature to analyze. Here we used text
text_feature = 'text'

# Remove NA Values
print("Removing NA values")
df = df.dropna()

# Randomize data (use random_state=42)
print("Shuffling data")
df = df.sample(frac=1, random_state=42)

# Clean out text and summary. For text, filter out anything below
# 1000 characters. For summary, filter out any that are empty
df = df[df['text'].str.replace(r'\s', '').str.len() > 1000]
df = df[df['summary'].str.strip() != '']

# Create target variable price movement
print("Creating target variable price movement")
df['price_movement'] = (df['article_price_close_stock'].shift(-1) > df['article_price_close_stock']).astype(int)

# Take out date for month
print("Converting date to month")
df['Date'] = pd.to_datetime(df['Date'])
df['month'] = df['Date'].dt.month
df = df.drop(['Date'], axis=1)

# Remove rows where open and close prices are the same
print("Removing rows where open and close prices are the same")
balanced_df = df[df['article_price_open_stock'] != df['article_price_close_stock']]

# Select 5000 instances for each class
print("Balancing data")
positive_instances = df[df['price_movement'] == 1].head(10000)
negative_instances = df[df['price_movement'] == 0].head(10000)

# Combine the data into a balanced DataFrame
balanced_df = pd.concat([positive_instances, negative_instances], ignore_index=True)

# Keep the original 'summary' and 'text' columns for reference
balanced_df['original_summary'] = balanced_df['summary']
balanced_df['original_text'] = balanced_df['text']

# Drop unnecessary columns
print("Dropping any unnecessary columns")
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
balanced_df['source_domain'] = label_encoder.fit_transform(balanced_df['source_domain'])

# Create a new column for spacy summary (verbs, adjectives, adverbs,...)
spacy_summary = []
count = 0
for text in balanced_df[text_feature]:
    tokens = spacy_model(text)
    selected_tokens = [token.text for token in tokens if token.pos_ in {'VERB', 'ADJ', 'ADV', 'NOUN', 'ADP'}]
    spacy_summary.append(' '.join(selected_tokens))
    count += 1
    print(count)
balanced_df[f'{text_feature}_spacy'] = spacy_summary

# Train TfidfVectorizer
vectorizer = TfidfVectorizer(
    max_features=500,
    stop_words='english'
)
X = vectorizer.fit_transform(balanced_df[f'{text_feature}_spacy'])

# Save the TfidfVectorizer
vectorizer_path = os.path.join(script_dir, 'tfidf_vectorizer.joblib')
joblib.dump(vectorizer, vectorizer_path)
print(f'TfidfVectorizer saved at: {vectorizer_path}')

# Split the data into training and testing sets
print("Splitting data into training and testing sets...")
X_train, X_test, y_train, y_test = train_test_split(X, balanced_df['price_movement'], test_size=0.2, random_state=42)

# Create a logistic regression model
model = LogisticRegression()

# Train the model
print("Training the model...")
model.fit(X_train, y_train)

# Save the model
model_path = os.path.join(script_dir, 'logistic_regression_model.joblib')
joblib.dump(model, model_path)
print(f'Model saved at: {model_path}')

# Make predictions on the test set
y_pred = model.predict(X_test)

# Print the classification report
print("Classification Report:")
print(classification_report(y_test, y_pred))

# Get feature names and TF-IDF scores
feature_names = vectorizer.get_feature_names_out()
tfidf_scores = model.coef_.flatten()

# Create a DataFrame for visualization
df_top_words = pd.DataFrame({'Word': feature_names, 'TF-IDF Score': tfidf_scores})
df_top_words = df_top_words.sort_values(by='TF-IDF Score', ascending=False).head(50)

# Plot the bar graph
plt.figure(figsize=(12, 8))
plt.barh(df_top_words['Word'], df_top_words['TF-IDF Score'])
plt.xlabel('TF-IDF Score')
plt.title('Top 50 Words based on TF-IDF Score')
graph_path = os.path.join(script_dir, 'Top 50 Words (Spacy).png')
plt.savefig(graph_path)
print(f'Top words graph saved at: {graph_path}')
plt.show()



'''
Classification Report:
              precision    recall  f1-score   support

           0       0.56      0.56      0.56      1981
           1       0.57      0.56      0.56      2019

    accuracy                           0.56      4000
   macro avg       0.56      0.56      0.56      4000
weighted avg       0.56      0.56      0.56      4000


'''

