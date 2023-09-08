package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckBoxTest {
  private CheckBox testCheckBox;


  @BeforeEach
  void setUp() {
    testCheckBox = new CheckBox();

  }
  @Test
  void isValid() {
    assertTrue(testCheckBox.isValid(Boolean.TRUE));
    assertTrue(testCheckBox.isValid(Boolean.FALSE));
    assertTrue(testCheckBox.isValid());


  }

  @Test
  void testHashCode() {
    int expectHashcode = Objects.hashCode(testCheckBox);
    assertEquals(expectHashcode,testCheckBox.hashCode());

  }

  @Test
  void testEquals() {
    CheckBox expectedObject = testCheckBox;
    assertTrue(testCheckBox.equals(expectedObject));


  }

  @Test
  void testToString() {
    String expectedString = "CheckBox{}";
    assertEquals(expectedString,testCheckBox.toString());


  }
}

