package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {
  private Music testMusic;
  private Music testMusic2;

  private RecordingArtist person1;
  private RecordingArtist person2;
  private RecordingArtist person3;
  private RecordingArtist person4;
  private RecordingArtist person5;

  private Band testBand;
  private Band testBand1;




  private ArrayList<RecordingArtist> testList;


  @BeforeEach
  void setUp() {

    person1 = new RecordingArtist("Arjun","Patel");
    person2 = new RecordingArtist("John","Wick");
    person3 = new RecordingArtist("Steve","Jobs");
    person4 = new RecordingArtist("Snoop","Dog");
    person5 = new RecordingArtist("Kakashi","Hatake");

    testList = new ArrayList<RecordingArtist>();
    testList.add(person1);
    testList.add(person2);
    testList.add(person3);
    testList.add(person4);
    testList.add(person5);

    testBand = new Band(testList,"Tropic Thunder");
    testBand1 = new Band(testList,"Crazy Lightning");



    testMusic = new Music("Hello Sun",1956,testBand);
    testMusic2 = new Music("TECHNO",2014,testBand);

  }


  @Test
  void getBand() {

    assertEquals(testBand,testMusic.getBand());


  }

  @Test
  void setBand() {
    testMusic.setBand(testBand1);
    assertEquals(testBand1,testMusic.getBand());

  }

  @Test
  void testEquals() {
    Music expectedobject = testMusic;
    assertFalse(testMusic2.equals(expectedobject));
  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testMusic);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testMusic.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Music{" +
        "titleOfItem='" + testMusic.titleOfItem + '\'' +
        ", itemYear=" + testMusic.itemYear +
        ", band=" + testMusic.band +
        '}';
    assertEquals(expectedString, testMusic.toString());
  }

  @Test
  void getAuthorItem() {
    assertEquals(new Author("",""),testMusic.getAuthorItem());

  }

  @Test
  void getRecordingArtistItem() {
    assertEquals(testList,testMusic.getRecordingArtistItem());
  }
}