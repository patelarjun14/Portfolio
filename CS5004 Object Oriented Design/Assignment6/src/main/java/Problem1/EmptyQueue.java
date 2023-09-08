package Problem1;

/**
 * This is a class for an empty queue
 */
public class EmptyQueue extends AQueue {

  /**
   * Here we are assigning a hashcode
   */
  private static final int HASH_CODE = 14202;


  /**
   * @return a Boolean to check if the queue is empty
   * Always false because this is a ConsQueue
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * @param priority This is an integer that states the priority in the queue (highest to lowest)
   * @param value    This is a string, which will be ordered by the priority in the queue
   * @return return a new ConsQueue. Once an element is added, the queue is no longer
   * defined as an EmptyQueue, which is why it becomes a ConsQueue
   */
  @Override
  public ConsQueue add(Integer priority, String value) {
    return new ConsQueue(priority,value,this);
  }

  /**
   * @return Nothing
   * @throws IllegalQueueException
   * An IllegalQueueException is always thrown because there are no elements in this queue
   */
  @Override
  public String peek() throws IllegalQueueException {
    throw new IllegalQueueException("There are no elements within this Queue");
  }

  /**
   * @return Nothing
   * @throws IllegalQueueException
   * An IllegalQueueException is always thrown because there are no elements in this queue
   */
  @Override
  public AQueue pop() throws IllegalQueueException {
    throw new IllegalQueueException("There are no elements within this Queue");
  }

  /**
   * @return integer
   * This will return the HASH_CODE that is assigned
   */
  @Override
  public int hashCode() {
    return EmptyQueue.HASH_CODE;
  }

  /**
   * @param obj An Object
   * @return Boolean
   * States whether if this object is equal to another
   */
  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(obj == null) {
      return false;
    }
    if(!(obj instanceof EmptyQueue)){
      return false;
    }
    return true;
  }

}
