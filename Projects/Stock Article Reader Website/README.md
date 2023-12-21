# CS6220-Fall2023-Project

## Overview

This project explores a website that leverages a Natural Language Processing (NLP) model trained on stock price movement. The application provides predictions based on the content of articles related to the stock market.

## How to Run the Applications

### Running the Streamlit App:

To launch the Streamlit app, follow these steps:

1. Navigate to the "streamlit app" folder in your terminal.
2. Run the following command:

    ```bash
    python home.py
    ```

### Running the React App:

#### Front end:

1. Navigate to the "website/src" folder in your terminal.
2. Run the following command:

    ```bash
    npm start
    ```

#### Backend:

1. Go to the "website/flask_app" folder in your terminal.
2. Execute the following command:

    ```bash
    python run_flask_app.py
    ```

## Project Structure:

- **Model Folder:** Contains all machine learning models.
- **Database Folder:** Includes code responsible for fetching data.

## Dependencies

Ensure you have the required dependencies installed by executing:

```bash
pip install pandas yfinance requests beautifulsoup4 matplotlib seaborn scikit-learn spacy flask flask-cors transformers
