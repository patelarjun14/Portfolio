package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorTest {
  private Author testAuthor;

  @BeforeEach
  void setUp() {
    testAuthor = new Author("Arjun","Patel");
  }

  @Test
  void testToString() {
    String expectedString = "Author{" +
        "firstName='" + testAuthor.firstName + '\'' +
        ", lastName='" + testAuthor.lastName + '\'' +
        '}';

    assertEquals(expectedString,testAuthor.toString());
  }
}