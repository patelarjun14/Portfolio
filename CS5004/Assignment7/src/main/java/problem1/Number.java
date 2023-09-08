package problem1;

import java.util.Objects;

/**
 * Number class that implements validator. Number input is a valid if the string can be converted
 * to the appropriate numeric format. This means that the value must be within the same range, decimals
 * must be in the set range, and cannot can invalid characters, such as letters from the alphabet.
 */
public class Number implements Validator<String> {

  private Integer maximumValue;
  private Integer minimumValue;
  private Integer maximumDecimalPlaces;

  /**
   * Constructor for the number validator
   * @param maximumValue - maximum value that can be entered
   * @param minimumValue - minimum value that can be entered
   * @param maximumDecimalPlaces - maximum decimal places that can be entered
   * @throws NegativeDecimalPlacesException - Exception thrown when negative decimal place is added
   * @throws MinMaxValueException - Exception when invalid values are entered for min and max
   */

  public Number(Integer maximumValue, Integer minimumValue, Integer maximumDecimalPlaces)
      throws NegativeDecimalPlacesException, MinMaxValueException {
    if(minMaxCheck(minimumValue, maximumValue)) {
      this.maximumValue = maximumValue;
      this.minimumValue = minimumValue;
    }
    else{
      throw new MinMaxValueException("The maximum value cannot be smaller than the min");
    }
    if(checkNegativeDecimal(maximumDecimalPlaces)) {
      this.maximumDecimalPlaces = maximumDecimalPlaces;
    }
    else{
      throw new NegativeDecimalPlacesException("You can't have negative decimal places");
    }
  }

  /**
   * Helper method to check that the minimum value is less or equal to the max value;
   * @param minimumValue - Minimum value that can be entered
   * @param maximumValue - Maximum value that can be entered
   * @return - true or false
   */
  private Boolean minMaxCheck(Integer minimumValue, Integer maximumValue){
    return minimumValue <= maximumValue;
  }

  /**
   * Helper method to check if maximum decimal place entered is negative
   * @param maximumDecimalPlaces - maximum decimal place
   * @return - true or false
   */
  private Boolean checkNegativeDecimal(Integer maximumDecimalPlaces){
    return maximumDecimalPlaces >=0;
  }

  /**
   * Gets the maximum value that can be entered
   * @return - maximum value
   */
  public Integer getMaximumValue() {
    return this.maximumValue;
  }

  /**
   * Sets the maximum value that can be entered
   * @param maximumValue - maximum value as an integer
   * @throws MinMaxValueException - exception is thrown if max < min.
   */
  public void setMaximumValue(Integer maximumValue) throws MinMaxValueException {

    if(minMaxCheck(this.minimumValue, maximumValue)) {
      this.maximumValue = maximumValue;
    }
    else{
      throw new MinMaxValueException("The maximum value cannot be smaller than the min");
    }
  }

  /**
   * Gets the minimum value that can be entered
   * @return - gets the minimum value
   */
  public Integer getMinimumValue() {
    return this.minimumValue;
  }

  /**
   * Sets the minimum value that can be entered
   * @param minimumValue - minimum value
   * @throws MinMaxValueException - exception if min is less than max value
   */
  public void setMinimumValue(Integer minimumValue) throws MinMaxValueException {
    if(minMaxCheck(minimumValue, this.maximumValue)) {
      this.minimumValue = minimumValue;
    }
    else{
      throw new MinMaxValueException("The minimum value cannot be larger than the max");
    }
  }

  /**
   * Gets the maximum amount of decimal places
   * @return - maximum amount of decimal places
   */
  public Integer getMaximumDecimalPlaces() {
    return this.maximumDecimalPlaces;
  }

  /**
   * Sets the maximum amount of decimal places
   * @param maximumDecimalPlaces - maximum decimal places
   * @throws NegativeDecimalPlacesException - exception if a negative amount of decimal places is entered
   */
  public void setMaximumDecimalPlaces(Integer maximumDecimalPlaces)
      throws NegativeDecimalPlacesException {

    if(checkNegativeDecimal(maximumDecimalPlaces)) {
      this.maximumDecimalPlaces = maximumDecimalPlaces;
    }
    else{
      throw new NegativeDecimalPlacesException("You can't have negative decimal places");
    }
  }

  /**
   * Helper method to check that the given string is between the min and max value and is a
   * numeric value with no allowed characters such as letters.
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  private boolean checkNumValue(String input) {
    try {
      double stringToNumber = Double.parseDouble(input);
      return stringToNumber <= this.maximumValue && stringToNumber >= this.minimumValue;
    }
    catch (NumberFormatException e){
      return false;
    }
  }

  /**
   * Helper method to check that a given string, when converted to a number, only less than or
   * equal to the max number of decimal places
   * @param input - User input to be checked as a string
   * @return - true or false
   */
  private boolean checkDecimalPlaces(String input) {
    if(!input.contains(".")){
      return true;
    }
      String[] splitNumber = input.split("\\.");
      return splitNumber[1].length() <= this.maximumDecimalPlaces;
  }

  /**
   * Method to check that text entered by a user can be converted to the appropriate numeric format.
   * A string must be able to be converted to a number, between the min and max values, and less
   * than or equal max amount of decimal places
   * @param input - User string to be validated
   * @return - true or false if the string meets the given criteria
   */
  @Override
  public boolean isValid(String input) {
    return checkNumValue(input) && checkDecimalPlaces(input);
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
    Number number = (Number) o;
    return Objects.equals(this.maximumValue, number.maximumValue) && Objects.equals(
        this.minimumValue, number.minimumValue) && Objects.equals(this.maximumDecimalPlaces,
        number.maximumDecimalPlaces);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.maximumValue, this.minimumValue, this.maximumDecimalPlaces);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Number{" +
        "maximumValue=" + this.maximumValue +
        ", minimumValue=" + this.minimumValue +
        ", maximumDecimalPlaces=" + this.maximumDecimalPlaces +
        '}';
  }
}
