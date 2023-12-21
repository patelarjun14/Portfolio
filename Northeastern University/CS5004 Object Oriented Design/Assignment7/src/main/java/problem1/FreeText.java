package problem1;

import java.util.Objects;

/**
 * FreeText: This validator will be used for free text fields such as messages or
 * comments. Client code will provide the number of lines in the text field and the number
 * of characters allowed per line. To be valid, input must be no longer than the number of
 * lines multiplied by the number of characters allowed per line.
 */
public class FreeText implements Validator<String> {
  private Integer numberOfLines;
  private Integer numberOfCharactersPerLine;

  /**
   * Constructor creating a new FreeText object
   * @param numberOfLines Number of lines in text box
   * @param numberOfCharactersPerLine number of characters per line
   */
  public FreeText(Integer numberOfLines, Integer numberOfCharactersPerLine) {
    this.numberOfLines = numberOfLines;
    this.numberOfCharactersPerLine = numberOfCharactersPerLine;
  }

  /**
   * Return number of lines within object
   * @return Integer: number of lines within object
   */
  public Integer getNumberOfLines() {
    return this.numberOfLines;
  }

  /**
   * Sets number of lines within object
   * @param numberOfLines Integer: number of lines within object
   * set the number of lines within object
   */
  public void setNumberOfLines(Integer numberOfLines) {
    this.numberOfLines = numberOfLines;
  }

  /**
   * Returns number of characters per line within object
   * @return Integer: number of characters per line within object
   */
  public Integer getNumberOfCharactersPerLine() {
    return this.numberOfCharactersPerLine;
  }


  /**
   * Set the number of characters per line within object
   * @param numberOfCharactersPerLine Integer: Number of characters per line
   */
  public void setNumberOfCharactersPerLine(Integer numberOfCharactersPerLine) {
    this.numberOfCharactersPerLine = numberOfCharactersPerLine;
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
    FreeText freeText = (FreeText) o;
    return Objects.equals(this.numberOfLines, freeText.numberOfLines)
        && Objects.equals(this.numberOfCharactersPerLine, freeText.numberOfCharactersPerLine);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.numberOfLines, this.numberOfCharactersPerLine);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "FreeText{" +
        "numberOfLines=" + this.numberOfLines +
        ", numberOfCharactersPerLine=" + this.numberOfCharactersPerLine +
        '}';
  }

  /**
   * Method to determine if the length of the input is equal to the length required
   * @param input String: Free text
   * @return Boolean: States whether the length of the input is equal to the length required
   */
  private boolean freeTextLength(String input){
    int length = input.length();
    int maximumLength = this.numberOfLines*this.numberOfCharactersPerLine;
    return length <=maximumLength;
  }

  /**
   * Method to determine the user input is a valid FreeText
   * @param input - General user input to be checked
   * @return A boolean to confirm whether the input is valid for FreeText
   */
  @Override
  public boolean isValid(String input) {
    return freeTextLength(input);
  }
}
