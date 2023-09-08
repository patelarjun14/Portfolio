package problem1;

/**
 * InvalidInputException is an Exception that is thrown when an invalid input is provided.
 */
public class InvalidInputException extends Exception {

  /**
   * Exception is thrown when there is an invalid input
   * @param message - Message to the user that the input is invalid
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
