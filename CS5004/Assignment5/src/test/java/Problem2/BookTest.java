package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
  private Book testBook;
  private Book testBook2;

  private Author testAuthor;
  private Author testAuthor2;

  private ArrayList<RecordingArtist> list;
  private RecordingArtist recordingArtist;


  @BeforeEach
  void setUp() {
    testAuthor = new Author("Arjun","Patel");
    testAuthor2 = new Author("Philip","Grenely");
    list = new ArrayList<RecordingArtist>();
    recordingArtist = new RecordingArtist("","");

    testBook = new Book("Why Dogs are Better",2012,testAuthor);
    testBook2 = new Book("Why Cats are Better",2013,testAuthor);

  }

  @Test
  void getAuthor() {
    assertEquals(testAuthor,testBook.getAuthor());
  }

  @Test
  void setAuthor() {
    testBook.setAuthor(testAuthor2);
    assertEquals(testAuthor2,testBook.getAuthor());

  }

  @Test
  void testEquals() {
    Book expectedobject = testBook;
    assertFalse(testBook2.equals(expectedobject));

  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testAuthor);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testAuthor.hashCode());
  }

  @Test
  void testToString() {
    String expectedString= "Book{" +
        "author=" + testBook.author +
        ", titleOfItem='" + testBook.titleOfItem + '\'' +
        ", itemYear=" + testBook.itemYear +
        '}';

    assertEquals(expectedString,testBook.toString());
  }

  @Test
  void getAuthorItem() {
    assertEquals(testAuthor,testBook.getAuthorItem());

  }

  @Test
  void getRecordingArtistItem() {
    assertEquals(list,testBook.getRecordingArtistItem());

  }
}