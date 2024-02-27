from flask import Flask, jsonify
import random
from datetime import datetime, timedelta

app = Flask(__name__)

# Categories as per your requirements
categories = [
    "Home & Utilities", "Transportation", "Groceries", "Personal & Family Care",
    "Health", "Insurance", "Restaurants & Dining", "Shopping & Entertainment",
    "Travel", "Cash, Checks & Misc", "Giving", "Business Expenses",
    "Education", "Finance", "Uncategorized"
]

# Function to generate a random transaction
def generate_random_transaction():
    category = random.choice(categories)
    merchant_names = ["Amazon", "Whole Foods", "Starbucks", "LinkedIn", "Netflix", "Chevron", "Apple", "Bluecross Blueshield", "One world children's fund", "airbnb","Morgan Stanely"]
    merchant_name = random.choice(merchant_names)
    amount = round(random.uniform(5.0, 500.0), 2)
    transaction_date = datetime.now() - timedelta(days=random.randint(0, 30))
    return {
        "date": transaction_date.strftime('%Y-%m-%d %H:%M:%S'),
        "category": category,
        "merchant_name": merchant_name,
        "amount": amount
    }

@app.route('/random_transaction', methods=['GET'])
def add_random_transaction():
    transaction = generate_random_transaction()
    return jsonify(transaction)

@app.route('/transactions', methods=['GET'])
def get_transactions():
    transactions = [generate_random_transaction() for _ in range(10)]  # Generate 10 random transactions
    return jsonify(transactions)

if __name__ == '__main__':
    app.run(debug=True)
