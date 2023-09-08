package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordTest {
  Password testPassword;

  @BeforeEach
  void setUp() throws MinMaxValueException {
    testPassword = new Password(5, 10);
  }

  @Test
  void testConstructorException() {
    assertThrows(MinMaxValueException.class, () -> new Password(10, 5));
    assertThrows(MinMaxValueException.class, () -> new Password(10, 5, 1, 1, 1));
    assertThrows(MinMaxValueException.class, () -> new Password(1, 10, 11, 0, 0));
    assertThrows(MinMaxValueException.class, () -> new Password(1, 10, 0, 11, 0));
    assertThrows(MinMaxValueException.class, () -> new Password(1, 10, 0, 0, 11));

  }

  @Test
  void getMinimumPasswordLength() {
    assertEquals(5, testPassword.getMinimumPasswordLength());
  }

  @Test
  void setMinimumPasswordLength() throws MinMaxValueException {
    testPassword.setMinimumPasswordLength(4);
    assertEquals(4, testPassword.getMinimumPasswordLength());

    assertThrows(MinMaxValueException.class, () -> {
      testPassword.setMinimumPasswordLength(11);
    }, "The minimum password length cannot be larger than the max");
  }

  @Test
  void getMaximumPasswordLength() {
    assertEquals(10, testPassword.getMaximumPasswordLength());
  }

  @Test
  void setMaximumPasswordLength() throws MinMaxValueException {
    testPassword.setMaximumPasswordLength(15);
    assertEquals(15, testPassword.getMaximumPasswordLength());

    assertThrows(MinMaxValueException.class, () -> {
      testPassword.setMaximumPasswordLength(4);
    }, "The maximum password length cannot be smaller than the min");
  }

  @Test
  void getMinLowerCases() {
    assertEquals(0, testPassword.getMinLowerCases());
  }

  @Test
  void setMinLowerCases() throws MinMaxValueException {
    testPassword.setMinLowerCases(5);
    assertEquals(5, testPassword.getMinLowerCases());
    assertThrows(MinMaxValueException.class, () -> testPassword.setMinLowerCases(15));
  }

  @Test
  void getMinUpperCases() {
    assertEquals(0, testPassword.getMinUpperCases());
  }

  @Test
  void setMinUpperCases() throws MinMaxValueException {
    testPassword.setMinUpperCases(3);
    assertEquals(3, testPassword.getMinUpperCases());
    assertThrows(MinMaxValueException.class, () -> testPassword.setMinUpperCases(15));

  }

  @Test
  void getMinDigits() {
    assertEquals(0, testPassword.getMinDigits());
  }

  @Test
  void setMinDigits() throws MinMaxValueException {
    testPassword.setMinDigits(3);
    assertEquals(3, testPassword.getMinDigits());
    assertThrows(MinMaxValueException.class, () -> testPassword.setMinDigits(15));


  }

  @Test
  void testEquals() throws MinMaxValueException {
    Password testSamePassword = new Password(5, 10);
    Password testPasswordDifferentMinLength = new Password(4, 10);
    Password testPasswordDifferentMaxLength = new Password(5, 11);
    Password testPasswordDifferentLowerCase = new Password(5, 10, 1, 0, 0);
    Password testPasswordDifferentUpperCase = new Password(5, 10, 0, 1, 0);
    Password testPasswordDifferentDigits = new Password(5, 10, 0, 0, 1);
    assertTrue(testPassword.equals(testPassword));
    assertTrue(testPassword.equals(testSamePassword));
    assertFalse(testPassword.equals(testPasswordDifferentMinLength));
    assertFalse(testPassword.equals(testPasswordDifferentMaxLength));
    assertFalse(testPassword.equals(testPasswordDifferentLowerCase));
    assertFalse(testPassword.equals(testPasswordDifferentUpperCase));
    assertFalse(testPassword.equals(testPasswordDifferentDigits));
    assertFalse(testPassword.equals(new CheckBox()));
    assertFalse(testPassword.equals(null));
  }

  @Test
  void testHashCode() throws MinMaxValueException {
    Password testSamePassword = new Password(5, 10);
    assertTrue(testPassword.equals(testSamePassword) && testSamePassword.equals(testPassword));
    assertTrue(testPassword.hashCode() == testSamePassword.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Password{" +
        "minimumPasswordLength=" + 5 +
        ", maximumPasswordLength=" + 10 +
        ", minLowerCases=" + 0 +
        ", minUpperCases=" + 0 +
        ", minDigits=" + 0 +
        '}';
    assertEquals(expectedString, testPassword.toString());
  }

  @Test
  void isValid() throws MinMaxValueException {
    assertTrue(testPassword.isValid("Password"));
    assertFalse(testPassword.isValid("Pass word"));
    assertFalse(testPassword.isValid("Fail"));
    assertFalse(testPassword.isValid("Fabrication"));
    testPassword.setMinLowerCases(1);
    assertFalse(testPassword.isValid("PASSWORD"));
    testPassword.setMinLowerCases(0);
    testPassword.setMinUpperCases(1);
    assertFalse(testPassword.isValid("password"));
    testPassword.setMinDigits(2);
    assertFalse(testPassword.isValid("Password"));
    assertTrue(testPassword.isValid("Password12"));
  }
}