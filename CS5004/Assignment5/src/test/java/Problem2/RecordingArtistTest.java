package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecordingArtistTest {
  private RecordingArtist testRecordingArtist;

  @BeforeEach
  void setUp() {
    testRecordingArtist = new RecordingArtist("Arjun","Patel");
  }

  @Test
  void testToString() {

    String expectedString = "RecordingArtist{}";
    assertEquals(expectedString, testRecordingArtist.toString());

  }




}