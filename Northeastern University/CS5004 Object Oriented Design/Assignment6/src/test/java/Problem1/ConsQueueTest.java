package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import Problem2.Queue;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsQueueTest {
  private ConsQueue testConQueue;
  private ConsQueue testConQueue2;

  @BeforeEach
  void setUp() {
    testConQueue = new ConsQueue(3,"Arjun",new EmptyQueue());
    testConQueue2 = new ConsQueue(2,"Tina",new EmptyQueue());

  }

  @Test
  void isEmpty() {
    assertEquals(false,testConQueue.isEmpty());
  }

  @Test
  void add() {
    testConQueue.add(2,"Tina");
    testConQueue.add(1,"John");

    assertEquals("Arjun",testConQueue.peek());
    assertEquals("Tina",testConQueue.pop().peek());
    assertEquals("John",testConQueue.pop().pop().peek());

    testConQueue.add(4,"Alex");
    assertEquals("Alex",testConQueue.peek());

    testConQueue.add(2,"Josh");
    assertEquals("Josh",testConQueue.pop().pop().peek());
    assertEquals("Tina",testConQueue.pop().pop().pop().peek());


  }

  @Test
  void peek() {
    testConQueue.add(2,"Tina");
    testConQueue.add(3,"Alex");
    assertEquals("Alex",testConQueue.peek());
  }

  @Test
  void pop() {
    testConQueue.add(2,"Tina");
    testConQueue.add(3,"Alex");
    testConQueue.add(4,"John");

    ConsQueue expected = new ConsQueue(1,"Arjun",new EmptyQueue());
    expected.add(2,"Tina");
    expected.add(3,"Alex");

    assertEquals(expected.peek(),testConQueue.pop().peek());

  }


  @Test
  void getPriority() {
    assertEquals(3,testConQueue.getPriority());
  }

  @Test
  void setPriority() {
    testConQueue.setPriority(2);
    assertEquals(2,testConQueue.getPriority());
  }

  @Test
  void getValue() {
    assertEquals("Arjun",testConQueue.getValue());
  }

  @Test
  void setValue() {
    testConQueue.setValue("Tina");
    assertEquals("Tina",testConQueue.getValue());
  }

  @Test
  void getQueue() {
    testConQueue.setQueue(new ConsQueue(1,"Jack",new EmptyQueue()));
    assertEquals("Jack",testConQueue.getQueue().peek());
  }

  @Test
  void setQueue() {
    testConQueue.setQueue(new ConsQueue(1,"Tina",new EmptyQueue()));
    assertEquals("Tina",testConQueue.getQueue().peek());
  }

  @Test
  void testEquals() {
    ConsQueue expectedObject = testConQueue;
    assertTrue(testConQueue.equals(expectedObject));
    assertFalse(testConQueue2.equals(expectedObject));

    testConQueue.add(2,"Tina");
    testConQueue2.add(3,"Arjun");
    assertTrue(testConQueue.equals(testConQueue2));


  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testConQueue);
    assertEquals(expectedHashcode,testConQueue.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "ConsQueue{" +
        "priority=" + testConQueue.getPriority() +
        ", value='" + testConQueue.getValue() + '\'' +
        ", queue=" + testConQueue.getQueue() +
        '}';
    assertEquals(expectedString, testConQueue.toString());
  }
}

