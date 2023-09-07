package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {
  private PriorityQueue testPriorityQueue;

  @BeforeEach
  void setUp() {
  }

  @Test
  void createEmpty() {
    assertEquals(true,PriorityQueue.createEmpty().isEmpty());


    PriorityQueue newQueue = PriorityQueue.createEmpty();
    assertEquals(true,newQueue.isEmpty());
    Assertions.assertThrows(IllegalQueueException.class, () -> {
      newQueue.peek();
    });
    Assertions.assertThrows(IllegalQueueException.class, () -> {
      newQueue.pop();
    });

  }
}