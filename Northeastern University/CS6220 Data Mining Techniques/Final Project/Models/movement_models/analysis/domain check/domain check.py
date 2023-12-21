'''
This file creates the domain source accuracies. The reason why we
want to look at this is to understand if we should filter our data based
on domain source. We found that domain sources based on sentiment of the articles
dont predict stock movements. 
'''

# Import the following
import pandas as pd
import matplotlib.pyplot as plt
import os

# Import data as DF using database
print("Loading data from database.xlsx")
script_dir = os.path.dirname(os.path.abspath(__file__))
file_path = os.path.join(script_dir, 'database.xlsx')
df = pd.read_excel(file_path, sheet_name='Sheet1')

# Create price movement by subtracting open and close 
df['price_movement'] = df['article_price_close_stock'] - df['article_price_open_stock']

# Filter out source domains with less than 100 articles
print("Filtering out source domains with less than 100 articles")
source_domain_counts = df['source_domain'].value_counts()
filtered_domains = source_domain_counts[source_domain_counts >= 100].index
df = df[df['source_domain'].isin(filtered_domains)]

# Calculate Accuracy scores
print("Calculating accuracy scores")

# Create column with accuracy score
df['accuracy_score'] = ((df['overall_sentiment_score'] > 0) & (df['price_movement'] > 0) |
                        (df['overall_sentiment_score'] < 0) & (df['price_movement'] < 0)).astype(int)

# Group source domain and accuracy score. Get the accuracy percentage by using mean
print("Grouping source domains and accuracy scores")
domain_accuracy = df.groupby('source_domain')['accuracy_score'].mean().reset_index()

# List top 10 source domains
print("List top 10 source domains")
top_10_domains = domain_accuracy.sort_values(by='accuracy_score', ascending=False).head(10)

# Plot the bar chart for top 10
plt.figure(figsize=(8, 6))
plt.bar(top_10_domains['source_domain'], top_10_domains['accuracy_score'])
plt.xlabel('Source Domain')
plt.ylabel('Accuracy Score')
plt.title('Top 10 Accuracy Scores by Source Domain')
plt.xticks(rotation=45, ha='right')
plt.subplots_adjust(bottom=0.3)

# Save the plot to a file in folder
output_file_path = os.path.join(script_dir, 'domain_source_accuracy.png')
plt.savefig(output_file_path)

# Show graph
plt.show()
