package problem1;

/**
 * Interface for a validator.
 * @param <T> - Generic data type.
 */

public interface Validator<T> {

  /**
   * Method to determine if the provided input meets the requirements.
   * @param input - General user input to be checked
   * @return - true or false depending on if the requirements are met
   */
  boolean isValid(T input);

}
