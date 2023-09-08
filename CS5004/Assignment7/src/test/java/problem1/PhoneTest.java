package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneTest {

  private Field testField;
  private Phone testPhone;
  private Phone testPhone2;


  @BeforeEach
  void setUp() {
    testPhone = new Phone(10);
    testPhone2 = new Phone(9);
    testField = new Field("Phone", true, testPhone);
  }

  @Test
  void getLength() {
    assertEquals(10, testPhone.getLength());
  }

  @Test
  void setLength() {
    testPhone.setLength(8);
    assertEquals(8, testPhone.getLength());
  }

  @Test
  void testEquals() {
    assertTrue(testPhone.equals(testPhone));
    assertFalse(testPhone.equals(testPhone2));
    assertFalse(testPhone.equals(null));

  }

  @Test
  void testHashCode() {
    Integer expectedHashCode = Objects.hash(testPhone.getLength());
    assertEquals(expectedHashCode, testPhone.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Phone{" +
        "length=" + testPhone.getLength() +
        '}';
    assertEquals(expectedString, testPhone.toString());
  }

  @Test
  void isValid() {
    assertEquals(false, testPhone.isValid("1234657"));
    assertEquals(false, testPhone.isValid("1234657"));
    assertEquals(false, testPhone.isValid("123456789a"));
    assertEquals(true, testPhone.isValid("1234567891"));
  }
}