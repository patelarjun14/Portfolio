'''
This file just creates graphs for vectors
'''
# Import the following
import joblib
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import os

# List positive files
positive_vectorizer_files = [
    'Models/movement_models/analysis/feature check/authors_positive_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/summary_positive_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/text_positive_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/title_positive_vectorizer_vectorizer.joblib'
]

# List Negative files
negative_vectorizer_files = [
    'Models/movement_models/analysis/feature check/authors_negative_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/summary_negative_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/text_negative_vectorizer_vectorizer.joblib',
    'Models/movement_models/analysis/feature check/title_negative_vectorizer_vectorizer.joblib'
]

# List output directory 
output_dir = 'Models/movement_models/analysis/vectorize check'

# Get base directory 
base_dir = os.getcwd()

# Create function
def create_and_save_plot(features, weights, key, sentiment, output_dir):
    words_weights_df = pd.DataFrame({'Word': features, 'Weight': weights})
    top_n = 50
    top_words_weights = words_weights_df.nlargest(top_n, 'Weight')

    # Wanted to use seaborn here to get better graphs to show with better colors
    plt.figure(figsize=(10, 6))
    sns.barplot(x='Weight', 
                y='Word', 
                data=top_words_weights, 
                palette='viridis')
    plt.title(f'Top {top_n} Words and Weights - {key} ({sentiment} Instances)')
    plt.xlabel('IDF Weight')
    plt.ylabel('Word')

    plot_filename = f'top_words_weights_{key}_{sentiment.lower()}.png'
    plot_filepath = os.path.join(output_dir, plot_filename)
    plt.savefig(plot_filepath, bbox_inches='tight')

    plt.show()
    plt.close()  

# Iterate through the positive files
for file in positive_vectorizer_files:
    key = os.path.basename(file).split('_')[0]
    file_path = os.path.join(base_dir, file)
    loaded_object = joblib.load(file_path)
    features = loaded_object.get_feature_names_out()
    weights = loaded_object.idf_
    create_and_save_plot(features, weights, key, 'Positive', output_dir)

# Iterate through the negative files
for file in negative_vectorizer_files:
    key = os.path.basename(file).split('_')[0]
    file_path = os.path.join(base_dir, file)
    loaded_object = joblib.load(file_path)
    features = loaded_object.get_feature_names_out()
    weights = loaded_object.idf_
    create_and_save_plot(features, weights, key, 'Negative', output_dir)

