package Problem2;

import java.util.Arrays;
import java.util.Objects;


//Create Queue structure
public class Queue implements IQueue {
  //Magic Numbers
  private static final int NOT_FOUND = -1;
  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THIRTY_ONE = 31;


  private static final int INITIAL_SIZE = 1;
  private Integer[] items;
  private int numItems;

//Create Constructor for
  public Queue() {
    this.items = new Integer[INITIAL_SIZE];
    this.numItems = ZERO;
  }

  public Queue(Integer[] items, Integer numItems) {
    this.items = items;
    this.numItems = numItems;
  }

//Create empty Queue method
  @Override
  public Queue emptyQueue() { //this is good
    return new Queue();
  }

//Create isEmpty Method
  @Override
  public Boolean isEmpty() { // this is good

    return (this.numItems==ZERO);
  }

//Create add method
  @Override
  public Queue add(Integer n) { // this is good
    Integer[] newItem;
    if(!inSizeRange()) {
      newItem = resize();
    } else {
      newItem = this.items;
    }
    newItem[this.numItems]=n;
    return new Queue(newItem,this.numItems+1);
    }


//Create Contains Method
  @Override
  public Boolean Contains(Integer n) { //this is good
      for(n = ZERO; n < this.numItems; n++) {
        if(n>= items.length || this.items[n].equals(n)){
          return false;
        }
      }
      return true;
  }

//Create remove method
  @Override
  public Queue remove() { //need to work on
    if(this.numItems == ZERO)
      return this;
    Integer[] newItem = new Integer[this.items.length - ONE];
    this.copyItems(this.items,newItem, ZERO, ONE, ZERO);
    return new Queue(newItem,this.numItems-ONE);

  }

//Create removeElement method
  @Override
  public Queue removeElement(Integer item) { //need to work on

    Integer[] newItem = new Integer[this.items.length];
    int newItemIndex = ZERO;
    int removedElements = ZERO;

    for(int i = ZERO; i < this.items.length; i++) {
      if(this.items[i] == item)
        removedElements ++;
      else
      newItem[newItemIndex] = this.items[i];
      newItemIndex++;
    }

    return new Queue(newItem, this.numItems-removedElements);
  }

//Create size method
  @Override
  public Integer size() { // this is good
    return this.numItems;
  }

//Helper functions

//Create inSizeRange method
  private boolean inSizeRange() {
    return this.numItems + ONE <= this.items.length;
  }


//Create resize method
  private Integer[] resize() {
    int newSize = this.numItems * TWO;
    Integer[] newItems = new Integer[newSize];
    copyItems(this.items, newItems, ZERO, this.items.length, ZERO);
    return newItems;
  }

//Create copyItems method
  private void copyItems(Integer[] items, Integer[] newItems, int i, int length, int i1) {
    if (i1 >= ZERO) {
      for (int n = i; n < length; n++) {
        newItems[i1] = items[n];
        i1++;
      }
    }
  }


//Create sameItems method
  private boolean sameItems(Integer[] items) {
    for(int n = ZERO; n < this.numItems; n++){
      if(n >= items.length || !this.items[n].equals(items[n]))
        return false;
    }
    return true;
  }

//Create Equals
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Queue that = (Queue) o;
    return numItems == that.numItems && this.sameItems(that.items);
  }

//Create hashCode
  @Override
  public int hashCode() {
    int result = Objects.hash(numItems);
    result = THIRTY_ONE * result + Arrays.hashCode(items);
    return result;
  }
}
