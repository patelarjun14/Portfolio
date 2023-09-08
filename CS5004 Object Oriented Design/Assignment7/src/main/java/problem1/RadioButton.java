package problem1;

/**
 * RadioButton class that implements validator. RadioButton input is a valid input if the box is checked as true or false.
 */
public class RadioButton implements Validator<Boolean> {

  private static final int HASH_CODE = 31;

  /**
   * Constructor for the radio button class
   */
  public RadioButton() {
  }

  /**
   * Method to determine if the input in the RadioButton is valid
   * @param input - User input as a Boolean to be checked
   * @return - true or false
   */
  @Override
  public boolean isValid(Boolean input){
    return Boolean.FALSE.equals(input) || Boolean.TRUE.equals(input);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return RadioButton.HASH_CODE;
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
    return "RadioButton{}";
  }
}
