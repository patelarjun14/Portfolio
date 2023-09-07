package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsBagOfWordsTest {
  private ConsBagOfWords testConsBagOfWords;
  private ConsBagOfWords testConsBagOfWords2;


  @BeforeEach
  void setUp() {
    testConsBagOfWords = new ConsBagOfWords("Arjun",new EmptyBagOfWords());
    testConsBagOfWords2 = new ConsBagOfWords("Tina",new EmptyBagOfWords());

  }

  @Test
  void isEmpty() {
    assertEquals(false,testConsBagOfWords.isEmpty());
    BagOfWords queue1 = testConsBagOfWords.add("Hello");
    assertEquals(false, queue1.isEmpty());

  }

  @Test
  void size() {
    assertEquals(1,testConsBagOfWords.size());
    BagOfWords queue1 = testConsBagOfWords.add("Hi");
    assertEquals(2,queue1.size());
    BagOfWords queue2 = queue1.add("Alex");
    assertEquals(3,queue2.size());
    BagOfWords queue3 = queue2.add("Alex");
    assertEquals(4,queue3.size());
    BagOfWords queue4 = queue3.add("John");
    assertEquals(5,queue4.size());

  }

  @Test
  void contains() {

    assertEquals(true,testConsBagOfWords.contains("Arjun"));
    assertEquals(false,testConsBagOfWords.contains("hi"));

    BagOfWords queue1 = testConsBagOfWords.add("Hi");
    assertEquals(true,queue1.contains("Hi"));
    assertEquals(true,queue1.contains("hi"));
    assertEquals(false,testConsBagOfWords.contains("Alex"));
    BagOfWords queue2 = queue1.add("Alex");
    assertEquals(true,queue2.contains("Alex"));
    assertEquals(true,queue2.contains("alex"));

  }

  @Test
  void getS() {
    assertEquals("Arjun",testConsBagOfWords.getS());
  }

  @Test
  void getQueue() {
    assertEquals(0, testConsBagOfWords.getQueue().size());

  }

  @Test
  void testEquals() {
    ConsBagOfWords expectedObject = testConsBagOfWords2;
    assertFalse(testConsBagOfWords.equals(expectedObject));
    assertTrue(testConsBagOfWords2.equals(expectedObject));
    assertTrue(testConsBagOfWords.add("Tina").equals(testConsBagOfWords2.add("Arjun")));
    assertTrue(testConsBagOfWords.add("Bryan").add("Tina").equals(testConsBagOfWords2.add("Arjun").add("Bryan")));


  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testConsBagOfWords);
    assertEquals(expectedHashcode,testConsBagOfWords.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "ConsBagOfWords{" +
        "s='" + testConsBagOfWords.getS() + '\'' +
        ", queue=" + testConsBagOfWords.getQueue() +
        '}';

    assertEquals(expectedString, testConsBagOfWords.toString());
  }




}