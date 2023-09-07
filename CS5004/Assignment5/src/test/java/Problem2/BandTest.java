package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import Problem1.Pledges;
import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BandTest {

  private Band testBand;
  private Band testBand2;

  private ArrayList<RecordingArtist> testList;

  private RecordingArtist person1;
  private RecordingArtist person2;
  private RecordingArtist person3;
  private RecordingArtist person4;
  private RecordingArtist person5;

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

    testBand = new Band(testList,"CrazyLightning");
    testBand2 = new Band(testList,"HELLO WORLD");

  }

  @Test
  void getBand() {
    assertEquals("CrazyLightning",testBand.getBand());
  }

  @Test
  void setBand() {
    testBand.setBand("CrazyLegs");
    assertEquals("CrazyLegs",testBand.getBand());
  }

  @Test
  void testEquals() {
    Band expectedobject = testBand;
    assertFalse(testBand2.equals(expectedobject));



  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testBand);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testBand.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Band{" +
        "band='" + testBand.band + '\'' +
        ", people=" + testBand.people +
        '}';

    assertEquals(expectedString,testBand.toString());
  }

}