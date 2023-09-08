package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RadioButtonTest {
  RadioButton testRadioButtonValidator;

  @BeforeEach
  void setUp() {
    testRadioButtonValidator = new RadioButton();
  }

  @Test
  void isValid() {
    assertTrue(testRadioButtonValidator.isValid(Boolean.TRUE));
    assertTrue(testRadioButtonValidator.isValid(Boolean.FALSE));
    assertFalse(testRadioButtonValidator.isValid(null));
  }

  @Test
  void testHashCode() {
    assertEquals(31, testRadioButtonValidator.hashCode());
  }

  @Test
  void testEquals() {
    CheckBox testCheckBoxValidator = new CheckBox();

    assertTrue(testRadioButtonValidator.equals(testRadioButtonValidator));
    assertFalse(testRadioButtonValidator.equals(testCheckBoxValidator));
    assertFalse(testRadioButtonValidator.equals(null));
  }

  @Test
  void testToString() {
    String expectedString = "RadioButton{}";
    assertEquals(expectedString, testRadioButtonValidator.toString());
  }
}