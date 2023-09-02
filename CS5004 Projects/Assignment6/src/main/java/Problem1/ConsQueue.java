package Problem1;

import java.util.Objects;

/**
 * @ConsQueue This is a queue that has 1 or more elements
 */
public class ConsQueue extends AQueue {

  private Integer priority;
  private String value;
  private PriorityQueue queue;

  private static final int RESULT_1 = 1;
  private static final int ZERO = 0;
  private static final int PRIME = 43;


  /**
   * @param priority This is the first element's priority (should be the highest)
   * @param value This is the first element's value
   * @param queue This will hold all the remaining queues. Each queue is wrapped to another.
   *              Queue represents the next element
   */
  public ConsQueue(Integer priority, String value, PriorityQueue queue) {
    this.priority = priority;
    this.value = value;
    this.queue = queue;
  }


  /**
   * @return a Boolean to check if the queue is empty
   * Always false because this is a ConsQueue, which has 1 or more elements
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }


  /**
   * @param priority This is an integer that states the priority in the queue (highest to lowest)
   * @param value    This is a string, which will be ordered by the priority in the queue
   * @return the queue with the added element
   * This is a recursive add method to store the element in the correct position (highest to lowest).
   * In Base Case 1, if the priority is equal to another priority in the queue, this will place the
   * element in front of the matching priority. For example, if (3,"Arjun") is entered and there is (3,"Tina")
   * then (3,"Arjun") will be in front of (3,"Tina"). This does not affect peek or pop because the queue
   * is already organized
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    // Base Case 1
      if(priority >= this.priority){
        this.queue = new ConsQueue(this.priority,this.value,this.queue);
        this.priority = priority;
        this.value = value;
        return this;

      }
      // Base Case 2
      else if(queue.isEmpty()){
        this.queue = new ConsQueue(priority,value,this.queue);
        return this;
      }
      // Start next iteration
      else{
        return this.queue.add(priority,value);
      }

    }


  /**
   * @return a string value of the first element in the queue (the highest priority)
   */
  @Override
  public String peek() {
    return this.value;
  }


  /**
   * @return the queue without the element with the highest priority
   */
  @Override
  public PriorityQueue pop(){
    return this.queue;
  }

  /**
   * @return An Integer
   * Returns the priority of an element
   */
  public Integer getPriority() {
    return priority;
  }


  /**
   * @param priority An integer
   * This will set or change the priority of element
   */
  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  /**
   * @return the value of the string in the element
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value A string
   * This will set or change the value of the string in the element
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return A queue or next element
   */
  public PriorityQueue getQueue() {
    return queue;
  }


  /**
   * @param queue A queue
   * This will set or change the queue
   */
  public void setQueue(PriorityQueue queue) {
    this.queue = queue;
  }

  /**
   * @param o An Object
   * @return A boolean to state whether if the 2 objects equal each other
   * Since this will be on priority, they should have the same order
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsQueue consQueue = (ConsQueue) o;
    return Objects.equals(priority, consQueue.priority) && Objects.equals(value,
        consQueue.value) && Objects.equals(queue, consQueue.queue);
  }


  /**
   * @return An integer of the hashcode value of an object
   */
  @Override
  public int hashCode() {
    final int prime = PRIME;
    int result = RESULT_1;
    result = (prime * result) + ((this.priority == null ) ? ZERO : this.priority.hashCode());
    result = (prime * result) + ((this.value == null ) ? ZERO : this.value.hashCode());
    result = (prime * result) + ((this.queue == null ) ? ZERO : this.queue.hashCode());
    return result;

  }

  /**
   * @return A string of the attributes of the class
   */
  @Override
  public String toString() {
    return "ConsQueue{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", queue=" + queue +
        '}';
  }


}
