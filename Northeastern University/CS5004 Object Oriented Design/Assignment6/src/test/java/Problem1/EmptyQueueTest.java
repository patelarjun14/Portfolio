package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyQueueTest {

  public EmptyQueue testEmptyQueue;
  public ConsQueue testEmptyQueue2;
  public EmptyQueue testEmptyQueue3;

  @BeforeEach
  void setUp() {

    testEmptyQueue = new EmptyQueue();
    testEmptyQueue2 = new ConsQueue(1,"Arjun",PriorityQueue.createEmpty());
    testEmptyQueue3 = new EmptyQueue();
  }

  @Test
  void isEmpty() {
    assertEquals(true, testEmptyQueue.isEmpty());
  }

  @Test
  void add() {

    ConsQueue newQueue1 = testEmptyQueue.add(3,"Tina");
    assertEquals(false,newQueue1.isEmpty());
    assertEquals("Tina",newQueue1.peek());

    newQueue1.add(2,"Arjun");
    assertEquals(false,newQueue1.isEmpty());
    assertEquals("Tina",newQueue1.peek());
    assertEquals("Arjun",newQueue1.pop().peek());

    newQueue1.add(4,"John");
    assertEquals(false,newQueue1.isEmpty());
    assertEquals("John",newQueue1.peek());
    assertEquals("Tina",newQueue1.pop().peek());
    assertEquals("Arjun",newQueue1.pop().pop().peek());

    newQueue1.add(1,"Alex");
    assertEquals(false,newQueue1.isEmpty());
    assertEquals("John",newQueue1.peek());
    assertEquals("Tina",newQueue1.pop().peek());
    assertEquals("Arjun",newQueue1.pop().pop().peek());
    assertEquals("Alex",newQueue1.pop().pop().pop().peek());


  }

  @Test
  void peek() {
    Assertions.assertThrows(IllegalQueueException.class, () -> {
      testEmptyQueue.peek();
    });
  }

  @Test
  void pop() {
    Assertions.assertThrows(IllegalQueueException.class, () -> {
      testEmptyQueue.pop();
    });
  }

  @Test
  void testHashCode() {
    assertEquals(14202,testEmptyQueue.hashCode());
  }

  @Test
  void testEquals() {
    EmptyQueue expectedObject = testEmptyQueue;
    assertTrue(testEmptyQueue3.equals(expectedObject));
    assertFalse(testEmptyQueue2.equals(expectedObject));
  }
}