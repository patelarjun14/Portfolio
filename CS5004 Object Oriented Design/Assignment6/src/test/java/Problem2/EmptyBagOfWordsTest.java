package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import Problem1.EmptyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyBagOfWordsTest {
  private EmptyBagOfWords testEmptyBagOfWords;

  @BeforeEach
  void setUp() {
    testEmptyBagOfWords = new EmptyBagOfWords();

  }

  @Test
  void isEmpty() {
    assertEquals(true, testEmptyBagOfWords.isEmpty());
    BagOfWords queue1 = testEmptyBagOfWords.add("Hello");
    assertEquals(false,queue1.isEmpty());
    assertEquals(1,queue1.size());
  }

  @Test
  void size() {
    assertEquals(0,testEmptyBagOfWords.size());
    BagOfWords queue1 = testEmptyBagOfWords.add("Hello");
    assertEquals(1,queue1.size());
    assertEquals(false,queue1.isEmpty());

  }

  @Test
  void contains() {

    assertEquals(false,testEmptyBagOfWords.contains("Arjun"));
    BagOfWords queue1 = testEmptyBagOfWords.add("Hello");
    assertEquals(1,queue1.size());
    assertEquals(false,queue1.isEmpty());
    assertEquals(true,queue1.contains("Hello"));
    assertEquals(true,queue1.contains("hello"));
    assertEquals(false,queue1.contains("Arjun"));
  }

  @Test
  void testHashCode() {
    assertEquals(24123,testEmptyBagOfWords.hashCode());
  }

  @Test
  void testEquals() {
    EmptyBagOfWords expectedObject = testEmptyBagOfWords;
    assertTrue(testEmptyBagOfWords.equals(expectedObject));
  }
}