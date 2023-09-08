package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import Problem1.ConsQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
  private ConsBagOfWords testQueue;

  @BeforeEach
  void setUp() {
    testQueue = new ConsBagOfWords("Arjun", new EmptyBagOfWords());

  }

  @Test
  void add() {
    BagOfWords queue1 = testQueue.add("Tina");
    BagOfWords queue2 = queue1.add("John");
    assertEquals(3,queue2.size());
    assertEquals(true,queue2.contains("Tina"));
    assertEquals(true,queue2.contains("Arjun"));
    assertEquals(true,queue2.contains("John"));


    }
  }