package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import Problem1.IllegalQueueException;
import Problem1.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BagOfWordsTest {

  @BeforeEach
  void setUp() {

  }

  @Test
  void emptyBagOfWords() {
    BagOfWords newQueue = BagOfWords.emptyBagOfWords();
    assertEquals(true, newQueue.isEmpty());
    assertEquals(0, newQueue.size());

  }

}