package problem1;

/**
 * Checkbox class that implements validator. Checkbox input is a valid input if the box is checked, not
 * checked or null.
 */
public class CheckBox implements Validator<Boolean> {

  private static final int HASH_CODE = 31;

  /**
   * Constructor for the CheckBox class
   */

  public CheckBox() {
  }

  /**
   * Method to check if the input in the CheckBox is valid
   * @param input - User input as a boolean
   * @return - true or false
   */
  @Override
  public boolean isValid(Boolean input) {
    return input.equals(true) || input.equals(false);
  }

  /**
   * Overloaded method that returns true when the value is null
   * @return - true
   */
  public boolean isValid() {
    return true;
  }


  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return CheckBox.HASH_CODE;
  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "CheckBox{}";
  }
}