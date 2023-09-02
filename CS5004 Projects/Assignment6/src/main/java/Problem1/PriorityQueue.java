package Problem1;

/**
 * This is an interface for PriorityQueue
 */
public interface PriorityQueue {

  /**
   * @return Returns an EmptyQueue
   */
  static PriorityQueue createEmpty(){
    return new EmptyQueue();
  }

  /**
   * @return Returns a Boolean to check if the queue is empty
   */
  Boolean isEmpty();

  /**
   * @param priority This is an integer that states the priority in the queue (highest to lowest)
   * @param value This is a string, which will be ordered by the priority in the queue
   * @return This will return the queue
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * @return This will return a string value of the first element in the queue (the highest priority)
   */
  String peek();

  /**
   * @return This will return the queue without the element with the highest priority
   */
  PriorityQueue pop();




}
