package problem1;

import java.util.Objects;

/**
 * Field is a class that represents a field in a Graphical User Interface (GUI).
 */
public class Field <T> implements FieldInterface <T> {

  private String label;
  private T value;
  private Boolean required;
  private Validator<T> validator;

  /**
   * Constructor, creating a new Field object.
   * A Field object consists of a label, value, required, and validator.
   * When a Field is first instantiated, value should be null.
   * @param label - The String label associated with the form field.
   * @param required - A boolean indicating whether a particular field must be completed
   * before the form can be submitted.
   * @param validator - a Validator that will perform input validation.
   */
  public Field(String label, Boolean required, Validator<T> validator) {
    this.label = label;
    this.value = null;
    this.required = required;
    this.validator = validator;
  }

  /**
   * Returns the field's label.
   * @return the field's label.
   */
  public String getLabel() {
    return this.label;
  }

  /**
   * Sets the field's label.
   * @param label - the String label associated with the form field.
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * Returns the field's value.
   * @return the field's value.
   */
  public T getValue() {
    return this.value;
  }

  /**
   * Returns whether a particular field must be completed before the form can be submitted.
   * @return whether a particular field must be completed before the form can be submitted.
   */
  public Boolean getRequired() {
    return this.required;
  }

  /**
   * Sets whether a particular field must be completed before the form can be submitted.
   * @param required - a boolean indicating whether a particular field must be completed
   * before the form can be submitted.
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }

  /**
   * Returns the Validator object.
   * @return the Validator object.
   */
  public Validator<T> getValidator() {
    return this.validator;
  }

  /**
   * Sets the Validator object.
   * @param validator - a Validator that will perform input validation.
   */
  public void setValidator(Validator<T> validator) {
    this.validator = validator;
  }

  /**
   * Method to update the Field’s value if the input is valid according to the validator.
   * The data type of input will either be String or Boolean depending on the type of data the
   * field accepts.
   * @param input - user provided input to update value.
   * @throws InvalidInputException an Exception that is thrown when an invalid input is provided.
   */
  public void updateValue(T input) throws InvalidInputException{
    if(!this.validator.isValid(input)){
      throw new InvalidInputException("Input is not valid");
    }
    this.value = input;
  }

  /**
   * Method to determine if a form is ready to submit.
   * @return True if the Field has been filled out and False otherwise.
   */
  public Boolean isFilled(){
    if(!this.required){
      return Boolean.TRUE;
    } else {
      return this.validator.isValid(this.value);
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
    Field<?> field = (Field<?>) o;
    return Objects.equals(this.label, field.label) && Objects.equals(this.value,
        field.value) && Objects.equals(this.required, field.required)
        && Objects.equals(this.validator, field.validator);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.label, this.value, this.required, this.validator);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Field{" +
        "label='" + this.label + '\'' +
        ", value=" + this.value +
        ", required=" + this.required +
        ", validator=" + this.validator +
        '}';
  }
}
