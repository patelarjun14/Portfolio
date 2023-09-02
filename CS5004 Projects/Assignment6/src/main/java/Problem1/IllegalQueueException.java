package Problem1;

/**
 * This is a class for catching Errors
 */
public class IllegalQueueException extends RuntimeException{

  /**
   * @param message A string
   * IllegalQueueException is thrown when program tries to return
   * a value that cannot be returned
   */
  public IllegalQueueException(String message) {
    super(message);
  }




}
