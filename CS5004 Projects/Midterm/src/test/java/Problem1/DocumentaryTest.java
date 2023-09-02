package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentaryTest {

  private Documentary testDocumentary;
  private ArrayList<Name> testString;
  private ArrayList<Name> testString2;
  private Name name1;
  private Name name2;



  @BeforeEach
  void setUp() {

    name1 = new Name("Arjun","H","Patel","Aj");
    name2 = new Name("Wyatt","H","Patel","Aj");



    testString = new ArrayList<Name>();
    testString.add(name1);


    testString2 = new ArrayList<Name>();
    testString2.add(name2);




    testDocumentary = new Documentary("Something",testString,testString2,1200.00,"EOS R5","Canon");
  }


  @Test
  void testToString() {
  }

  @Test
  void cameraModelFactor() {
  }

  @Test
  void calculateStartingBid() {
    assertEquals(2844,testDocumentary.calculateStartingBid());  }
}