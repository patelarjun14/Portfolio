package problem1;

/**
 * Interface for a field class.
 * @param <T> - Generic data type.
 */

public interface FieldInterface<T> {

  /**
   * Method to update the Field’s value if the input is valid according to the validator.
   * The data type of input will either be String or Boolean depending on the type of data the
   * field accepts.
   * @param input - user provided input to update value.
   * @throws InvalidInputException an Exception that is thrown when an invalid input is provided.
   */
  void updateValue(T input) throws InvalidInputException;

  /**
   * Method to determine if a form is ready to submit.
   * @return True if the Field has been filled out and False otherwise.
   */
  Boolean isFilled();
}
