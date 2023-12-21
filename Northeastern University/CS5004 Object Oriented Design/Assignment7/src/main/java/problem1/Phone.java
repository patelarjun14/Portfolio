package problem1;


import java.util.Objects;

/**
 *  A valid phone number is a String that contains only digits and has a specified
 * length supplied by client code. The length must match exactly.
 */
public class Phone implements Validator<String> {
  private Integer length;


  /**
   * Constructor for the Phone class
   * @param length Integer: Length of the phone number
   */
  public Phone(Integer length) {
    this.length = length;
  }

  /**
   * Returns length of the phone number
   * @return Integer: Length of phone number
   */
  public Integer getLength() {
    return this.length;
  }

  /**
   * Sets length of the phone number
   * @param length Integer: Set length of the phone number
   */
  public void setLength(Integer length) {
    this.length = length;
  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Phone phone = (Phone) o;
    return Objects.equals(this.length, phone.length);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.length);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Phone{" +
        "length=" + this.length +
        '}';
  }

  /**
   * Method to determine if the input only contains digits
   * @param input String: Phone number
   * @return Boolean: States whether if the input only contains digits
   */
  private boolean containsOnlyDigits(String input){
    Integer count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isDigit(input.charAt(i))){
        count++;
      }
    }
    return count.equals(input.length());
  }

  /**
   * Method to determine whether the length matches the required length
   * @param input String: Phone number
   * @return Boolean: States whether the length matches the required length
   */
  private boolean validLength(String input) {
    Integer count = 0;
    for (int i = 0; i < input.length(); i++) {
      if (Character.isDigit(input.charAt(i))) {
        count++;
      }
    }
    return count.equals(this.length);
  }


  /**
   * Method to determine if the user input is a valid Phone number
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for
   * phone number
   */
  @Override
  public boolean isValid(String input) {
      return containsOnlyDigits(input) && validLength(input);

    }
}
