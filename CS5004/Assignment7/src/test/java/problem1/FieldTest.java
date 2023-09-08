package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTest {
  Password testPasswordValidator;
  Field testField;


  @BeforeEach
  void setUp() throws MinMaxValueException {
    testPasswordValidator = new Password(5, 10);
    testField = new Field("Password", Boolean.TRUE, testPasswordValidator);
  }

  @Test
  void getLabel() {
    assertEquals("Password", testField.getLabel());
  }

  @Test
  void setLabel() {
    testField.setLabel("Field");
    assertEquals("Field", testField.getLabel());
  }

  @Test
  void getValue() {
    assertEquals(null, testField.getValue());
  }

  @Test
  void getRequired() {
    assertEquals(Boolean.TRUE, testField.getRequired());
  }

  @Test
  void setRequired() {
    testField.setRequired(Boolean.FALSE);
    assertEquals(Boolean.FALSE, testField.getRequired());
  }

  @Test
  void getValidator() {
    assertEquals(testPasswordValidator, testField.getValidator());
  }

  @Test
  void setValidator() {
    CheckBox testCheckBoxValidator = new CheckBox();
    testField.setValidator(testCheckBoxValidator);
    assertEquals(testCheckBoxValidator, testField.getValidator());
  }

  @Test
  void updateValue() throws InvalidInputException {
    testField.updateValue("Password");
    assertEquals("Password", testField.getValue());

    assertThrows(InvalidInputException.class, () -> {
      testField.updateValue("Fail");
    }, "Input is not valid");
  }

  @Test
  void isFilled() throws InvalidInputException {
    assertFalse(testField.isFilled());

    testField.setRequired(Boolean.FALSE);
    assertTrue(testField.isFilled());

    testField.updateValue("Password");
    assertTrue(testField.isFilled());
  }

  @Test
  void testEquals() throws InvalidInputException, MinMaxValueException {
    Field testSameField = new Field("Password", Boolean.TRUE, testPasswordValidator);
    Field testFieldDifferentLabel = new Field("Different", Boolean.TRUE, testPasswordValidator);
    Field testFieldDifferentRequired = new Field("Password", Boolean.FALSE, testPasswordValidator);
    Field testFieldDifferentValidator = new Field("Password", Boolean.TRUE, new Password(4, 10));


    assertTrue(testField.equals(testField));
    assertTrue(testField.equals(testSameField));
    assertFalse(testField.equals(testFieldDifferentLabel));
    assertFalse(testField.equals(testFieldDifferentRequired));
    assertFalse(testField.equals(testFieldDifferentValidator));

    Field testFieldDifferentInput = new Field("Password", Boolean.TRUE, testPasswordValidator);
    testField.updateValue("Password");
    testFieldDifferentInput.updateValue("Matthew");
    assertFalse(testField.equals(testFieldDifferentInput));

    assertFalse(testField.equals(testPasswordValidator));
    assertFalse(testField.equals(null));
  }

  @Test
  void testHashCode() {
    Field testSameField = new Field("Password", Boolean.TRUE, testPasswordValidator);
    assertTrue(testField.equals(testSameField) && testSameField.equals(testField));
    assertTrue(testField.hashCode() == testSameField.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Field{" +
        "label='" + "Password" + '\'' +
        ", value=" + null +
        ", required=" + Boolean.TRUE +
        ", validator=" + testPasswordValidator +
        '}';
    assertEquals(expectedString, testField.toString());
  }

}