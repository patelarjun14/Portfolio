package problem1;

/**
 * MinMaxValueException is an Exception that is thrown when the max is less than the min
 */
public class MinMaxValueException extends Exception {

  /**
   * This throws an exception when minimum value is larger than the maximum value or when the
   * maximum value is less than the minimum value
   * @param message: Message to the user that the input is invalid
   */
  public MinMaxValueException(String message) {
    super(message);
  }
}
