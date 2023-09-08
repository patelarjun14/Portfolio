import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split, cross_val_score, StratifiedKFold
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import classification_report, confusion_matrix
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt


# Load data
data = pd.read_csv('final_merged_data_with_income.csv')

# List of feature columns
feature_columns = ['Close', 'High', 'Low', 'Open', 'Volume', 'RSI', 'MACD_Fast', 'MACD_Signal',
                    'SMA', 'WEI', 'VIX', 'FFR', 'UNEMPLOYMENT', 'CPI', 'Treasury 10-Year', 
                    'Recession Prob', 'Crude_Oil_WTI', 'Gold', 'Silver', 'Copper', 'Wheat', 'Natural_Gas', 
                    'Corn', 'Cotton', 'Coffee', 'Sugar', 'Weekly Mean', 'Quarterly Mean', 'Annual Mean', 
                    'Annual Weekly Mean', 'Annual Quarterly Mean', 'Weekly Trend', 'Daily Range', 'Daily Volatility', 
                    'Mean Reported EPS', 'Mean Estimated EPS', 'grossProfit', 'totalRevenue', 'costOfRevenue',
                    'costofGoodsAndServicesSold', 'operatingIncome', 'sellingGeneralAndAdministrative', 
                    'researchAndDevelopment', 'operatingExpenses', 'investmentIncomeNet', 'netInterestIncome', 
                    'interestIncome', 'interestExpense', 'nonInterestIncome', 'otherNonOperatingIncome', 
                    'depreciation', 'depreciationAndAmortization', 'incomeBeforeTax', 'incomeTaxExpense', 
                    'interestAndDebtExpense', 'netIncomeFromContinuingOperations', 'comprehensiveIncomeNetOfTax', 
                    'ebit', 'ebitda', 'netIncome'
                    ]

# Use target column
target_column = ['Target']

# X should be all features
X = data[feature_columns]

# Y should be target
y = data[target_column].values.ravel()

# Split data
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.1, random_state=42)

# Use Standard Scaler
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

# Ablation study
inverse_of_regularization = [0.001, 
                             0.01, 
                             0.1, 
                             1.0, 
                             10.0, 
                             100.0, 
                             1000.0, 
                             10000.0, 
                             100000.0, 
                             1000000.0]

# Get Mean scores
mean_scores = []  
for test in inverse_of_regularization:
    model = LogisticRegression(C=test, max_iter=10000)
    scores = cross_val_score(model, X_train_scaled, y_train, cv=5, scoring='accuracy')
    mean_score = np.mean(scores)
    mean_scores.append(mean_score)
    print(f"C: {test}, Mean cross validation score: {mean_score}")

# Find the best c index based on mean scores
best_config_idx = np.argmax(mean_scores)
best_config = inverse_of_regularization[best_config_idx]
print("Best C:", best_config)

# fit best model
best_model = LogisticRegression(C=best_config, max_iter=10000)
best_model.fit(X_train_scaled, y_train)

# Evaluate the model on the test set
y_pred = best_model.predict(X_test_scaled)
print(classification_report(y_test, y_pred))
print(confusion_matrix(y_test, y_pred))


# Split data for testing (10%)
split_index = int(0.9 * len(data))

# Split data into testing
test_data = data.iloc[split_index:]

# Find mistakes
mistake_indices = np.where(y_test != y_pred)[0]


# Record extreme mistake data
extreme_mistake_date = []
extreme_mistake_price = []

# Get data on mistakes
for index in mistake_indices:
    mistake_date = test_data.iloc[index]["Date"]
    mistake_price = test_data.iloc[index]["Close"]
    mistake_features = X_test_scaled[index]
    predicted_probability = best_model.predict_proba([mistake_features])[0][1]
    print("Mistake made on:", mistake_date, "Predicted probability:", predicted_probability)
    if predicted_probability > 0.70:
        extreme_mistake_date.append(index)
        extreme_mistake_price.append(round(mistake_price, 2))

# Create a list of indices
index = list(range(len(test_data)))

# Plot data
plt.figure()
plt.plot(index, test_data['Close'], label='SPY Price', color='blue')
plt.scatter(extreme_mistake_date, extreme_mistake_price, color='red', label='Extreme Mistake')
plt.xlabel('Date')
plt.ylabel('Price')
plt.title('SPY Price and Extreme Mistakes')
plt.legend()
plt.show()