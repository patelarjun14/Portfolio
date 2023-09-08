package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreeTextTest {

  private Field testField;
  private FreeText testFreeText;
  private FreeText testFreeText2;
  private FreeText testFreeText3;
  private FreeText testFreeText4;
  private FreeText testFreeText5;

  @BeforeEach
  void setUp() {
    testFreeText = new FreeText(3, 50);
    testFreeText2 = new FreeText(1, 15);
    testFreeText3 = new FreeText(3, 15);
    testFreeText4 = new FreeText(1, 50);
    testFreeText5 = new FreeText(3, 50);

    testField = new Field<>("FreeText", false, testFreeText);
    //testField.setValue("Setting the values to be tested");
  }

  @Test
  void getNumberOfLines() {
    assertEquals(3, testFreeText.getNumberOfLines());
  }

  @Test
  void setNumberOfLines() {
    testFreeText.setNumberOfLines(5);
    assertEquals(5, testFreeText.getNumberOfLines());
  }

  @Test
  void getNumberOfCharactersPerLine() {
    assertEquals(50, testFreeText.getNumberOfCharactersPerLine());
  }

  @Test
  void setNumberOfCharactersPerLine() {
    testFreeText.setNumberOfCharactersPerLine(100);
    assertEquals(100, testFreeText.getNumberOfCharactersPerLine());
  }

  @Test
  void testEquals() {

    assertTrue(testFreeText.equals(testFreeText));
    assertFalse(testFreeText.equals(testFreeText2));
    assertFalse(testFreeText.equals(null));
    assertFalse(testFreeText.equals(testFreeText3));
    assertFalse(testFreeText.equals(testFreeText4));
    assertTrue(testFreeText.equals(testFreeText5));
  }



  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testFreeText.getNumberOfLines(), testFreeText.getNumberOfCharactersPerLine());
    assertEquals(expectedHash, testFreeText.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "FreeText{" +
        "numberOfLines=" + testFreeText.getNumberOfLines() +
        ", numberOfCharactersPerLine=" + testFreeText.getNumberOfCharactersPerLine() +
        '}';
    assertEquals(expectedString, testFreeText.toString());
  }

  @Test
  void freeTextLength() {
    assertEquals(true, testFreeText.isValid("Test that will pass"));
    assertEquals(false, testFreeText2.isValid("Test that will fail"));

  }

  @Test
  void isValid() {

    assertEquals(true,testFreeText.isValid("Testing the Free Text Validator"));
    assertEquals(false, testFreeText2.isValid("This should not pass this test"));
    assertEquals(true, testField.getValidator().isValid(("Testing the Free Text Validator")));

  }
}