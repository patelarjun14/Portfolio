package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GroupTest {
  private ArrayList<RecordingArtist> testGroup;

  private RecordingArtist person1;
  private RecordingArtist person2;
  private RecordingArtist person3;
  private RecordingArtist person4;
  private RecordingArtist person5;


  @Test
  void getPeople() {

    person1 = new RecordingArtist("Arjun","Patel");
    person2 = new RecordingArtist("John","Wick");
    person3 = new RecordingArtist("Steve","Jobs");
    person4 = new RecordingArtist("Snoop","Dog");
    person5 = new RecordingArtist("Kakashi","Hatake");

    testGroup = new ArrayList<RecordingArtist>();
    testGroup.add(person1);
    testGroup.add(person2);
    testGroup.add(person3);
    testGroup.add(person4);
    testGroup.add(person5);

  }

  @Test
  void setPeople() {
  }

  @Test
  void testEquals() {
  }

  @Test
  void testHashCode() {
  }

  @Test
  void testToString() {

  }
}