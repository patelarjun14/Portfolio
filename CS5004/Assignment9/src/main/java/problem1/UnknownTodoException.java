package problem1;

/**
 * InvalidArgumentsException is an Exception that is thrown when an invalid argument is provided.
 */
public class UnknownTodoException extends Exception {
  /**
   * Exception is thrown when there is an invalid argument.
   * @param message - Message to the user that the argument is invalid.
   */
  public UnknownTodoException(String message) {
    super(message);
  }
}