package problem1;


import java.util.Objects;

/**
 * Password - A password is a String has the following properties:
 * ○ Minimum and maximum acceptable length (inclusive).
 * ○ The minimum number of lowercase letters that the password must contain
 * (default = 0, which means that lowercase letters are not required).
 * ○ The minimum number of uppercase letters that the password must contain
 * (default = 0).
 * ○ The minimum number of digits that the password must contain (default = 0).
 * To be valid, a password must meet the length requirements and contain at least the
 * minimum number of each character type. Additionally, a valid password cannot contain a
 * space (“ “). To keep things simple, all other characters are allowed.
 */
public class Password implements Validator<String> {
  private Integer minimumPasswordLength;
  private Integer maximumPasswordLength;
  private Integer minLowerCases = 0;
  private Integer minUpperCases = 0;
  private Integer minDigits = 0;

  /**
   * Constructor creating a new Password object
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @param minLowerCases Integer: Minimum amount of lower cases within password
   * @param minUpperCases Integer: Minimum amount of upper cases within password
   * @param minDigits Integer: Minimum amount of digits within password
   * @throws MinMaxValueException Throws exception when minimum or maximum password
   * length is entered incorrectly based on parameters
   * This constructor allows user to change parameters with defaults
   */
  public Password(Integer minimumPasswordLength, Integer maximumPasswordLength,
      Integer minLowerCases, Integer minUpperCases, Integer minDigits) throws
      MinMaxValueException {
      Boolean truthGate1 = minMaxCheck(minimumPasswordLength, maximumPasswordLength);
      Boolean truthGate2 = minMaxLengthCheck(minLowerCases, minUpperCases, minDigits,maximumPasswordLength);
    if(truthGate1) {
      this.minimumPasswordLength = minimumPasswordLength;
      this.maximumPasswordLength = maximumPasswordLength;
    }
    else{
      throw new MinMaxValueException("The maximum length cannot be smaller than the minimum length");
    }
    if(truthGate2) {
      this.minLowerCases = minLowerCases;
      this.minUpperCases = minUpperCases;
      this.minDigits = minDigits;
    }
    else{
      throw new MinMaxValueException("The minimum lower cases, upper cases, and digits cannot be larger than the maximum length");
    }
  }

  /**
   * Constructor with reduced parameters creating a new Password object
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @throws MinMaxValueException Throws exception when minimum or maximum password
   * length is entered incorrectly based on parameters
   * This constructor allows user to not change defaults
   */
  public Password(Integer minimumPasswordLength, Integer maximumPasswordLength) throws
      MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, maximumPasswordLength)) {
    this.minimumPasswordLength = minimumPasswordLength;
    this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  /**
   * Checks if the minimum password length is less than or equal to the maximum password length
   * @param minimumPasswordLength Integer: Minimum Password Length
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @return Boolean
   */
  private Boolean minMaxCheck(Integer minimumPasswordLength, Integer maximumPasswordLength) {
    return minimumPasswordLength <= maximumPasswordLength;
  }

  /**
   * Checks if the minimum lower cases, minimum upper cases, and minimum digits is less than or
   * equal to maximum password length
   * @param minLowerCases Integer: Minimum amount of lower cases within password
   * @param minUpperCases Integer: Minimum amount of upper cases within password
   * @param minDigits Integer: Minimum amount of digits within password
   * @param maximumPasswordLength Integer: Maximum Password Length
   * @return Boolean: States whether if the minimum and maximum length check is valid (true)
   */
  private Boolean minMaxLengthCheck(Integer minLowerCases, Integer minUpperCases,
      Integer minDigits, Integer maximumPasswordLength){
    return (minLowerCases+minUpperCases+minDigits) <= maximumPasswordLength;
  }

  /**
   * Returns minimum password length
   * @return Integer: Object's minimum password length
   */
  public Integer getMinimumPasswordLength() {
    return this.minimumPasswordLength;
  }


  /**
   * Sets minimum password length
   * @param minimumPasswordLength Integer: Set minimum password length
   * @throws MinMaxValueException Throws exception when minimum password
   * length is greater than the max
   */
  public void setMinimumPasswordLength(Integer minimumPasswordLength) throws MinMaxValueException {
    if(minMaxCheck(minimumPasswordLength, this.maximumPasswordLength)) {
      this.minimumPasswordLength = minimumPasswordLength;
    } else {
      throw new MinMaxValueException("The minimum password length cannot be larger than the max");
    }
  }

  /**
   * Returns maximum password length
   * @return Integer: Object's maximum password length
   */
  public Integer getMaximumPasswordLength() {
    return this.maximumPasswordLength;
  }

  /**
   * Sets the maximum password length
   * @param maximumPasswordLength Integer: set maximum password length
   * @throws MinMaxValueException Throws exception when maximum password length is less than
   * the minimum password length
   */
  public void setMaximumPasswordLength(Integer maximumPasswordLength) throws MinMaxValueException {
    if(minMaxCheck(this.minimumPasswordLength, maximumPasswordLength)) {
      this.maximumPasswordLength = maximumPasswordLength;
    } else {
      throw new MinMaxValueException("The maximum password length cannot be smaller than the min");
    }
  }

  /**
   * Returns minimum lower cases amount
   * @return Integer: Object's minimum lower cases amount
   */
  public Integer getMinLowerCases() {
    return this.minLowerCases;
  }

  /**
   * Sets the amount of minimum lower cases
   * @param minLowerCases Integer: Set the amount of minimum lower cases
   */
  public void setMinLowerCases(Integer minLowerCases) throws MinMaxValueException {
    if(minMaxLengthCheck(minLowerCases, this.minUpperCases, this.minDigits,this.maximumPasswordLength)){
      this.minLowerCases = minLowerCases;
    } else {
      throw new MinMaxValueException("the minimum upper cases, lower cases, and digits cannot be greater than the maximum length");
    }
  }

  /**
   * Returns minimum upper cases amount
   * @return Integer: Object's minimum upper cases amount
   */
  public Integer getMinUpperCases() {
    return this.minUpperCases;
  }

  /**
   * Sets the amount of minimum upper cases
   * @param minUpperCases Integer: Set the amount of minimum upper cases
   */
  public void setMinUpperCases(Integer minUpperCases) throws MinMaxValueException {
    if (minMaxLengthCheck(minLowerCases, minUpperCases, this.minDigits,
        this.maximumPasswordLength)) {
      this.minUpperCases = minUpperCases;
    } else {
      throw new MinMaxValueException("the minimum upper cases, lower cases, and digits cannot be greater than the maximum length");
    }
  }

  /**
   * Returns the object's minimum digits
   * @return Integer: Object's minimum digits
   */
  public Integer getMinDigits() {
    return this.minDigits;
  }

  /**
   * Sets the object's minimum digits
   * @param minDigits Integer: Set minimum digits within password
   */
  public void setMinDigits(Integer minDigits) throws MinMaxValueException {
    if (minMaxLengthCheck(minLowerCases, minUpperCases, minDigits,
        this.maximumPasswordLength)) {
      this.minDigits = minDigits;
    } else {
      throw new MinMaxValueException("the minimum upper cases, lower cases, and digits cannot be greater than the maximum length");
    }
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
    Password password = (Password) o;
    return Objects.equals(this.minimumPasswordLength, password.minimumPasswordLength)
        && Objects.equals(this.maximumPasswordLength, password.maximumPasswordLength)
        && Objects.equals(this.minLowerCases, password.minLowerCases)
        && Objects.equals(this.minUpperCases, password.minUpperCases)
        && Objects.equals(this.minDigits, password.minDigits);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.minimumPasswordLength, this.maximumPasswordLength, this.minLowerCases, this.minUpperCases,
        this.minDigits);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Password{" +
        "minimumPasswordLength=" + this.minimumPasswordLength +
        ", maximumPasswordLength=" + this.maximumPasswordLength +
        ", minLowerCases=" + this.minLowerCases +
        ", minUpperCases=" + this.minUpperCases +
        ", minDigits=" + this.minDigits +
        '}';
  }

  /**
   * This is a helper method to check the input is an acceptable length
   * @param input A string for password
   * @return A boolean to state whether the password has a valid length
   */
  private boolean isAcceptableLength(String input){
    if (input == null) {
      return Boolean.FALSE;
    } else {
      int length = input.length();
      return (length >= this.minimumPasswordLength && length <= this.maximumPasswordLength);
    }
  }

  /**
   * This is a helper method to check the input has the required minimum amount of lower cases
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   * number of minimum lower cases
   */
  private boolean hasMinimumLowerCases(String input){
    int count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isLowerCase(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minLowerCases;
  }


  /**
   * This is a helper method to check the input has the required minimum amount of upper cases
   * @param input A string for password
   * @return A boolean to state whether the password has valid
   */
  private boolean hasMinimumUpperCases(String input){
    int count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isUpperCase(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minUpperCases;
  }

  /**
   * This is a helper method to check the input has the required minimum amount of digits
   * @param input A string for password
   * @return A boolean to state whether the password has valid number of minimum digits
   */
  private boolean hasMinimumDigits(String input) {
    int count = 0;
    for(int i =0; i<input.length(); i++){
      if(Character.isDigit(input.charAt(i))){
        count++;
      }
    }
    return count>=this.minDigits;
  }

  /**
   * This is a helper method to check the string has no spaces
   * @param input A string for password
   * @return A boolean to state whether the password has no space
   */
  private boolean hasNoSpace(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (String.valueOf(input.charAt(i)).equals(" ")) {
        return false;
      }
    }
    return true;
  }

  /**
   * Method to determine the user input is a valid password
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for Password
   */
  @Override
  public boolean isValid(String input) {
    return isAcceptableLength(input) &&
        hasMinimumLowerCases(input) &&
        hasMinimumUpperCases(input) &&
        hasMinimumDigits(input) &&
        hasNoSpace(input);
    }
}

 // Citations:
 // #1 - https://www.tutorialspoint.com/check-whether-a-character-is-lowercase-or-not-in-java#:~:text=To%20check%20whether%20a%20character,isLowerCase()%20method.
 // #2 - https://www.geeksforgeeks.org/convert-a-string-to-character-array-in-java/


