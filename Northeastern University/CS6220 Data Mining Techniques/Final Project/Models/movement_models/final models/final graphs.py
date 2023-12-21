'''
This creates confusion and ROC graphs
'''

# Import the following
import pandas as pd
import joblib
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics import roc_curve, roc_auc_score, confusion_matrix
import os
from sklearn.pipeline import Pipeline

# Load sorted data
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'final_sorted_data.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Get 20% tail of data
test_size = int(0.2 * len(df))
test_data = df.tail(test_size)

# Create X_test and y_test
X_test = test_data['text_spacy']
y_test = test_data['price_movement']

# Store models
models = [
    'gradientboostingclassifier_model_accuracy_0.54.joblib',
    'LogisticRegression_model_accuracy_0.54.joblib',
    'randomforestclassifier_model_accuracy_0.55.joblib',
    'kneighborsclassifier_model_accuracy_0.51.joblib'
]

# Store vectorizers
vectorizers = [
    'gradientboostingclassifier_vectorizer.joblib',
    'LogisticRegression_vectorizer.joblib',
    'randomforestclassifier_vectorizer.joblib',
    'kneighborsclassifier_vectorizer.joblib'
]

# Zip models and vectorizers to iterate through
for model_file, vectorizer_file in zip(models, vectorizers):
    
    # Get file paths 
    model_file_path = os.path.join(script_dir, model_file)
    vectorizer_file_path = os.path.join(script_dir, vectorizer_file)

    # Load the model and vectorizer 
    model = joblib.load(model_file_path)
    vectorizer = joblib.load(vectorizer_file_path)

    # Create a pipeline with the vectorizer and model
    pipeline = Pipeline([
        ('vectorizer', vectorizer),
        ('model', model)
    ])

    # Make predictions on the test data
    y_pred_proba = pipeline.predict_proba(X_test)[:, 1]

    # Calculate ROC curve and AUC
    false_pos_rate, true_pos_rate, thresholds = roc_curve(y_test, y_pred_proba)
    area_under_curve = roc_auc_score(y_test, y_pred_proba)

    # Plot ROC curve
    plt.figure(figsize=(10, 10))
    plt.plot(false_pos_rate, 
             true_pos_rate, 
             label=f'{model_file}'
    )
    plt.plot([0, 1], 
             [0, 1], 
             color='gray', 
             label='Random')
    plt.title('ROC Curve')
    plt.xlabel('False Positive Rate')
    plt.ylabel('True Positive Rate')
    plt.legend()

    # Save ROC curve 
    roc_curve_filename = f'ROC_curve_{model_file}.png'
    plt.savefig(os.path.join(script_dir, roc_curve_filename))
    
    # Show the plot
    plt.show()

    # Plot confusion matrix
    y_pred = pipeline.predict(X_test)
    cm = confusion_matrix(y_test, y_pred)
    plt.figure(figsize=(10, 10))
    sns.heatmap(cm, 
                cmap='Blues', 
                xticklabels=['Predicted 0', 'Predicted 1'],
                yticklabels=['Actual 0', 'Actual 1'])
    plt.title(f'Confusion Matrix for {model_file}')

    # Save Confusion Matrix
    confusion_matrix_filename = f'Confusion_Matrix_{model_file}.png'
    plt.savefig(os.path.join(script_dir, confusion_matrix_filename))

    # Show the plot
    plt.show()
