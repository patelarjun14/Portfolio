from flask import Blueprint, jsonify, request
from summarizer import Summarizer
from flask_cors import CORS

# Create Blueprint
summary_app = Blueprint('summary_app', __name__)
CORS(summary_app)

@summary_app.route('/generate_summary', methods=['POST'])
def generate_summary():
    """
    Generates a summary for the provided input using the BERT-based summarization model.

    Endpoint: '/generate_summary' (POST)

    Parameters:
    - summary (str): The input text for which the summary is to be generated.
    - max_length (int): The maximum length of the generated summary.
    - min_length (int): The minimum length of the generated summary.
    - num_sentences (int): The desired number of sentences in the generated summary.

    Returns:
    - JSON response with the user input and the generated summary.

    Example Usage:
    ```
    POST '/generate_summary'
    {
        "summary": "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
        "max_length": 150,
        "min_length": 50,
        "num_sentences": 3
    }
    ```

    Sample Response:
    ```
    {
        "user_input": "Lorem ipsum dolor sit amet, consectetur adipiscing elit...",
        "generated_summary": "Generated summary text..."
    }
    ```
    """
    try:
        # Get Inputs from user
        data = request.json
        summary = data['summary']
        max_length = data['max_length']
        min_length = data['min_length']
        num_sentences = data['num_sentences']

        # Use BERT model to summarize our input
        summarizer = Summarizer()
        generated_summary = summarizer(summary, max_length=max_length, min_length=min_length, num_sentences=num_sentences)

        # Return as JSON
        return jsonify({"user_input": summary, "generated_summary": generated_summary})

    except Exception as e:
        return jsonify({"error": str(e)})
