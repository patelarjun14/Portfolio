package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

  private Queue testQueue;

  @BeforeEach
  void setUp() {
    Integer[] array = {1, 2, 3, 4, 5};
    testQueue = new Queue(array, 5);

  }

  @Test
  void emptyQueue() {
    assertEquals(new Queue(), testQueue.emptyQueue());
  }

  @Test
  void isEmpty() {
    assertEquals(false, testQueue.isEmpty());
  }

  @Test
  void add() {
    Queue x = testQueue.add(6);
    assertEquals(6, x.size());
    assertEquals(true, x.Contains(6));

  }

  @Test
  void contains() {
    assertEquals(true, testQueue.Contains(4));
  }

  @Test
  void remove() {
    Queue x = testQueue.remove();
    assertEquals(4, x.size());
  }

  @Test
  void removeElement() {
    assertEquals(4, testQueue.removeElement(1).size());
    //assertEquals(false,testQueue.Contains(3));

  }

  @Test
  void size() {
    assertEquals(5, testQueue.size());
  }

  @Test
  void Contains() {
    assertEquals(true, testQueue.Contains(3));
  }




  @Test
  void testEquals() {
    Integer[] array = {1, 2, 2, 3, 5};
    Queue expectedObject = new Queue(array, 5);
    Queue testObject = new Queue(array, 5);
    assertTrue(testObject.equals(expectedObject) && expectedObject.equals(testObject)
        && testObject.hashCode() == expectedObject.hashCode());
    assertFalse(testQueue.equals(expectedObject));
  }

}
