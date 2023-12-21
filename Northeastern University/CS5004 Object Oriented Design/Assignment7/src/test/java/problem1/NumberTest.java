package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {
  private Number testNumber;
  private Number testNumber2;
  private MinMaxValueException testNumber3;

  @BeforeEach
  void setUp() throws NegativeDecimalPlacesException, MinMaxValueException {
    testNumber = new Number(10,2,2);
    testNumber2 = new Number(5,2,2);
    testNumber3 = new MinMaxValueException("You can't have negative decimal places");

  }

  @Test
  void testConstructorException() {
    assertThrows(NegativeDecimalPlacesException.class, () -> new Number(10, 1, -1));
  }

  @Test
  void getMaximumValue() {
    assertEquals(10,testNumber.getMaximumValue());
  }

  @Test
  void setMaximumValue() throws MinMaxValueException {
    testNumber.setMaximumValue(9);
    assertEquals(9,testNumber.getMaximumValue());

    assertThrows(MinMaxValueException.class,() ->{
      testNumber.setMaximumValue(1);
    });

  }

  @Test
  void getMinimumValue() {
    assertEquals(2,testNumber.getMinimumValue());
  }

  @Test
  void setMinimumValue() throws MinMaxValueException {
    testNumber.setMinimumValue(5);
    assertEquals(5,testNumber.getMinimumValue());

    assertThrows(MinMaxValueException.class,() ->{
      testNumber.setMinimumValue(500);
    });
  }

  @Test
  void getMaximumDecimalPlaces() {
    assertEquals(2,testNumber.getMaximumDecimalPlaces());
  }

  @Test
  void setMaximumDecimalPlaces() throws NegativeDecimalPlacesException {
    testNumber.setMaximumDecimalPlaces(4);
    assertEquals(4,testNumber.getMaximumDecimalPlaces());

    assertThrows(NegativeDecimalPlacesException.class,() ->{
      testNumber.setMaximumDecimalPlaces(-1);
    });

  }

  @Test
  void testIsValid() {
    assertTrue(testNumber.isValid("4.32"));
    assertFalse(testNumber.isValid("1"));
    assertFalse(testNumber.isValid("11"));
    assertTrue(testNumber.isValid("8"));
    assertFalse(testNumber.isValid("111111111111111111"));
    assertFalse(testNumber.isValid("4a"));
    assertFalse(testNumber.isValid(""));
    assertFalse(testNumber.isValid("23.3242"));
    assertFalse(testNumber.isValid("23.3gwq242"));

  }

  @Test
  void testEquals() throws NegativeDecimalPlacesException, MinMaxValueException {
    Number expectedObject = testNumber;
    assertTrue(testNumber.equals(expectedObject));
    assertFalse(testNumber.equals(testNumber2));
    assertFalse(testNumber.equals(new Number(10,4,2)));
    assertFalse(testNumber.equals(new Number(10,2,5)));
    assertFalse(testNumber.equals(null));
    assertFalse(testNumber.equals(new CheckBox()));

  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testNumber);
    assertEquals(expectedHashcode,testNumber.hashCode());

  }

  @Test
  void testToString() {
    String expectedString = "Number{" +
        "maximumValue=" + testNumber.getMaximumValue() +
        ", minimumValue=" + testNumber.getMinimumValue() +
        ", maximumDecimalPlaces=" + testNumber.getMaximumDecimalPlaces() +
        '}';

    assertEquals(expectedString, testNumber.toString());

  }
}

