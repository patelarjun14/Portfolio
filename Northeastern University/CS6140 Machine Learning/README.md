# CS6140 Machine Learning

# Homework 1 Overview

In Homework 1, Arjun Patel undertook the following tasks:

- Replicated exploratory data analysis from a provided R specimen using Python.
- Created visualizations, including a scatter plot exploring the relationship between GHG scores and fuel types.
- Built a predictive model for fuel efficiency in cities, selecting the 'UCity' variable as the target.
- Addressed challenges related to model evaluation and overfitting, considering techniques such as ridge regression or lasso regularization.
- Conducted variable selection, excluding those deemed irrelevant to understanding fuel efficiency.

This summary provides a concise overview of the tasks and achievements in Homework 1.

# Homework 2 Overview

In Homework 2, Arjun Patel tackled two problems related to logistic regression:

## Problem 1: Logistic Regression and Weight Update Rule (30 points)

Consider a logistic regression problem with \(x \in \mathbb{R}^d\) and \(y \in \{0,1\}\). The objective is to derive the weight update rule maximizing the conditional likelihood for a given dataset \(D = \{(x_i, y_i)\}^n\) where \(i = 1\).

- **Class Conditional Probabilities:**
  - Utilized the sigmoid function (\(\sigma(x) = \frac{1}{1+e^{-x}}\)) to find class conditional probabilities.
  - Calculated probabilities for \(P(y=1|x)\) and \(P(y=0|x)\).

- **Likelihood for a Single Observation:**
  - Employed the Bernoulli distribution for combining probabilities.
  - Derived likelihood expression: \(P(y|x,w) = \sigma(w^t \cdot x)^y \cdot (1 - \sigma(w^t \cdot x))^{1-y}\).

- **Log Likelihood and Logistic Loss:**
  - Converted likelihood to log likelihood.
  - Introduced logistic loss or cross-entropy as the error function.

- **Gradient Descent (Weight Update):**
  - Applied gradient descent to update weights for maximum likelihood.
  - Update rule: \(w^k = w^{k-1} - \eta \Delta E(w)\).

## Problem 2: Sigmoid Function and Posterior Calculation (30 points)

Given the sigmoid function \(\sigma(a) = \frac{1}{1+e^{-a}}\), Arjun addressed the following questions:

- **Derivative Calculation:**
  - Computed \(\frac{\delta \sigma(a)}{\delta w}\) when \(a = w^t \cdot x\).
  - Result: \(\frac{\delta \sigma(a)}{\delta w} = \sigma(w^t \cdot x)(1 - \sigma(w^t \cdot x)) \cdot x\).

- **Posterior Calculation for Logistic Regression:**
  - Formulated the posterior \(P(y|x,w)\) in the context of logistic regression.
  - Utilized \(P(y=1|x,w) = 1 - \sigma(w^t \cdot x)\).

This summary provides a concise overview of the problem-solving steps and key concepts explored in Homework 2.

