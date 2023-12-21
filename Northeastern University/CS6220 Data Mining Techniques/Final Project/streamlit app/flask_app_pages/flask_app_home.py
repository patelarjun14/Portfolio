from flask import Blueprint, jsonify, request
import joblib
import os

# Create Blueprint
home_app = Blueprint('home_app', __name__)

# Use current Directory
current_directory = os.path.dirname(__file__)

# Get Model for Movement
model_path_movement = os.path.join(current_directory, 'Logistic Regression_accuracy_0.61.joblib')
loaded_model_movement = joblib.load(model_path_movement)

# Get Model for Sentiment
model_path_sentiment = os.path.join(current_directory, 'Random Forest Regression_mse_0.02_r2_0.22.joblib')
loaded_model_sentiment = joblib.load(model_path_sentiment)

# Get Models for Relevance (We will be able to call multiple models from this)
model_path_relevance = os.path.join(current_directory, 'best_models_dictionary.joblib')
models_path_relevance = joblib.load(model_path_relevance)

@home_app.route('/predict_relevance', methods=['POST'])
def predict_relevance():
    """
    Predicts the relevance of an article to a given topic using a pre-trained machine learning model.

    Endpoint: '/predict_relevance' (POST)

    Parameters:
    - article (dict): Dictionary containing article text. Example: {"article": {"text": "Article content"}, "topic": "Finance"}

    Returns:
    - JSON response with the predicted relevance score.

    Example Usage:
    ```
    POST '/predict_relevance'
    {
        "article": {
            "text": "This is the content of the article."
        },
        "topic": "Finance"
    }
    ```

    Sample Response:
    ```
    {
        "prediction": 0.85
    }
    ```
    """
    try:
        data = request.get_json()
        article_text = data.get('article', {}).get('text', '')
        topic = data.get('topic', '')

        if topic not in models_path_relevance:
            return jsonify({'Error': f'Model for topic "{topic}" not found'})

        best_model = models_path_relevance[topic]
        prediction = best_model.predict([article_text])[0]

        prediction = round(float(prediction), 2)

        return jsonify({'prediction': prediction})

    except Exception as e:
        return jsonify({'Error': str(e)})

@home_app.route('/predict_sentiment', methods=['POST'])
def prediction_sentiment():
    """
    Predicts the sentiment score of an article using a pre-trained machine learning model.

    Endpoint: '/predict_sentiment' (POST)

    Parameters:
    - article (dict): Dictionary containing article text. Example: {"article": {"text": "Article content"}}

    Returns:
    - JSON response with the predicted sentiment score.

    Example Usage:
    ```
    POST '/predict_sentiment'
    {
        "article": {
            "text": "This is the content of the article."
        }
    }
    ```

    Sample Response:
    ```
    {
        "sentiment": 0.72
    }
    ```
    """
    try:
        data = request.get_json()
        article_text = data.get('article', {}).get('text', '')

        prediction = loaded_model_sentiment.predict([article_text])

        result = {'sentiment': round(prediction[0], 2)}

        return jsonify(result)

    except Exception as e:
        return jsonify({'Error': str(e)})

@home_app.route('/predict_movement', methods=['POST'])
def prediction_movement():
    """
    Predicts the movement of a stock based on an article using a pre-trained machine learning model.

    Endpoint: '/predict_movement' (POST)

    Parameters:
    - article (dict): Dictionary containing article text. Example: {"article": {"text": "Article content"}}

    Returns:
    - JSON response with the predicted movement ('up' or 'down') and likelihood.

    Example Usage:
    ```
    POST '/predict_movement'
    {
        "article": {
            "text": "This is the content of the article."
        }
    }
    ```

    Sample Response:
    ```
    {
        "prediction": "up",
        "likelihood": 75.0
    }
    ```
    """
    try:
        data = request.get_json()
        article_text = data.get('article', {}).get('text', '')

        prediction = loaded_model_movement.predict([article_text])
        likelihood = loaded_model_movement.predict_proba([article_text])[0][1] * 100

        output = 'up' if prediction[0] == 1 else 'down'

        result = {'prediction': output, 'likelihood': likelihood}

        return jsonify(result)

    except Exception as e:
        return jsonify({'Error': str(e)})
