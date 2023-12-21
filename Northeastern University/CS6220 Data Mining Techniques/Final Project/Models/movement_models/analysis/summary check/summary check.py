'''
We wanted to analyze what would happen if we vectorized summary and
trained it on summary and text. We actually noticed a improvment in accuracy
which shows vectorizing on smaller text can prove to be beneficial
'''

# Import the following
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.feature_extraction.text import TfidfVectorizer
import os
import joblib
from sklearn.preprocessing import LabelEncoder
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report

# Load data from database.xlsx
print("Loading data from database.xlsx")
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'database.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Define features
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
    'Technology'
]
categorical_columns = ['stock', 'source_domain']

# Data Cleaning
print("Removing rows with NA values")
df = df.dropna()

# Shuffle Data
print("Shuffling the data")
df = df.sample(frac=1, random_state=42)

# Clean text and summary
print("Cleaning out text and summary")
df = df[df['text'].str.replace(r'\s', '').str.len() > 1000]
df = df[df['summary'].str.strip() != '']

# Add price movement
print("Adding price movement")
df['price_movement'] = (df['article_price_close_stock'].shift(-1) > df['article_price_close_stock']).astype(int)

# Take out articles that have the same open and close price
print("Removing articles with the same open and close price")
balanced_df = df[df['article_price_open_stock'] != df['article_price_close_stock']]

# Balance the data
print("Balancing data")
positive_instances = df[df['price_movement'] == 1].head(10000)
negative_instances = df[df['price_movement'] == 0].head(10000)
balanced_df = pd.concat([positive_instances, negative_instances], ignore_index=True)

# Save references
print("Saving references")
balanced_df['original_summary'] = balanced_df['summary'].copy()
balanced_df['original_text'] = balanced_df['text'].copy()

# Drop usless columns
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

# Sort by date
sorted_df = balanced_df.sort_values(by='Date')

# Split data
train_df, test_df = train_test_split(sorted_df, test_size=0.2, shuffle=False)

# Split into summary, text, and train/test
X_train_summary, y_train_movement = train_df['summary'], train_df['price_movement']
X_test_summary, y_test_movement = test_df['summary'], test_df['price_movement']
X_train_text, X_test_text = train_df['text'], test_df['text']

# Vectorize summary
vectorizer = TfidfVectorizer(max_features=10000, stop_words='english')
X_train_vectorized = vectorizer.fit_transform(X_train_summary)
X_test_vectorized_summary = vectorizer.transform(X_test_summary)

# Train model using vectorized text from summary
model = LogisticRegression()
model.fit(X_train_vectorized, y_train_movement)
y_pred_summary = model.predict(X_test_vectorized_summary)
accuracy_summary = accuracy_score(y_test_movement, y_pred_summary)
print(f"Accuracy (Summary-based Model): {accuracy_summary:.2f}")
print("Classification Report (Summary-based Model):")
print(classification_report(y_test_movement, y_pred_summary))

# Save vectorizer and summary model
print("Saving vectorizer and model...")
vectorizer_file = os.path.join(script_dir, 'vectorizer_summary.joblib')
model_file = os.path.join(script_dir, 'model_summary.joblib')
joblib.dump(vectorizer, vectorizer_file)
joblib.dump(model, model_file)

# Save file with top 50 words
feature_names = vectorizer.get_feature_names_out()
coefficients = model.coef_.flatten()

# Print top 50 words 
top_features = pd.Series(coefficients, index=feature_names).sort_values(ascending=False).head(50)
top_features.plot(kind='barh', figsize=(12, 8))
plt.title('Top 50 Words in Vectorizer')
plt.xlabel('Coefficient Value')
plt.ylabel('Word')
plt.tight_layout()
graph_file = os.path.join(script_dir, 'top_50_words.png')
plt.savefig(graph_file)
plt.show()

# Now transform text using summary
X_text_train_vectorized = vectorizer.transform(X_train_text)
X_text_test_vectorized = vectorizer.transform(X_test_text)

# Train model using vectorizer text from summary
model_text = LogisticRegression()
model_text.fit(X_text_train_vectorized, y_train_movement)
y_pred_text = model_text.predict(X_text_test_vectorized)
accuracy_text = accuracy_score(y_test_movement, y_pred_text)
print(f"Accuracy (Text-based Model): {accuracy_text:.2f}")
print("Classification Report (Text-based Model):")
print(classification_report(y_test_movement, y_pred_text))

# Save vectorizer text and model text
print("Saving vectorizer and model for text")
vectorizer_text_file = os.path.join(script_dir, 'vectorizer_text.joblib')
model_text_file = os.path.join(script_dir, 'model_text.joblib')
joblib.dump(model_text, model_text_file)


'''
Accuracy (Summary-based Model): 0.54
Classification Report (Summary-based Model):
              precision    recall  f1-score   support

           0       0.57      0.51      0.54      2097
           1       0.52      0.57      0.54      1903

    accuracy                           0.54      4000
   macro avg       0.54      0.54      0.54      4000
weighted avg       0.55      0.54      0.54      4000

Saving vectorizer and model...
Accuracy (Text-based Model): 0.56
Classification Report (Text-based Model):
              precision    recall  f1-score   support

           0       0.59      0.54      0.56      2097
           1       0.53      0.59      0.56      1903

    accuracy                           0.56      4000
   macro avg       0.56      0.56      0.56      4000
weighted avg       0.56      0.56      0.56      4000

Saving vectorizer and model for text

'''