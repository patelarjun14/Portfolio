package Problem2;

import Problem1.ConsQueue;
import java.util.Locale;
import java.util.Objects;

/**
 * This class is for BagOfWords that contains
 * 1 or more elements
 */
public class ConsBagOfWords extends Queue {

  private final String s;
  private final BagOfWords queue;
  private static final int ONE = 1;

  /**
   * @param s A String
   * @param queue A queue
   * The string is the first element while the queue represents the
   * next element
   */
  public ConsBagOfWords(String s, BagOfWords queue) {
    this.s = s;
    this.queue = queue;
  }

  /**
   * @return A boolean
   * This will always be false because a ConsBagOfWords has 1 or more elements
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }


  /**
   * @return An integer
   * This will return the size of a ConsBagOfWords
   */
  @Override
  public Integer size() {
    return ONE + this.queue.size();
  }


  /**
   * @param s A string
   * @return A boolean
   * This will confirm if the entered string is in the BagOfWords.
   * This is not case-sensitive
   */
  @Override
  public Boolean contains(String s) {
    // Base Case 1
    if(s.toLowerCase().equals(this.s.toLowerCase())){
      return true;
    }
    // Base Case 2
    else if(this.queue.isEmpty()){
      return false;
    }
    // Start next iteration
    else{
      return this.queue.contains(s);
    }
  }

  /**
   * @return A string
   * Returns the string of an element in ConsBagOfWords
   */
  public String getS() {
    return s;
  }


  /**
   * @return A queue
   * This queue is the next elements (each queue wraps around another)
   */
  public BagOfWords getQueue() {
    return queue;
  }

  /**
   * @param o An object
   * @return Boolean
   * This confirms whether if 2 queues have the same elements
   */
  @Override
  public boolean equals(Object o) {
    final ConsBagOfWords other = (ConsBagOfWords) o;
    if (this.queue.isEmpty() && other.queue.isEmpty()) {
      if (this.s == other.s) {
        return true;
      }
    }
    else if(other.contains(this.s) && this.queue.isEmpty()){
        return true;
    }
    else if (other.contains(this.s)) {
      return this.queue.equals(o);
    } else {
      return false;
    }
    return false;
  }


  /**
   * @return An integer of the hashcode value of an object
   */
  @Override
  public int hashCode() {
    return Objects.hash(s, queue);
  }

  /**
   * @return A string of the attributes of the class
   */
  @Override
  public String toString() {
    return "ConsBagOfWords{" +
        "s='" + s + '\'' +
        ", queue=" + queue +
        '}';
  }



}
