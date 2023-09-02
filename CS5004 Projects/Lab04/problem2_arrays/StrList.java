package problem2_arrays;

import java.sql.Array;
import java.util.Arrays;
import java.util.Objects;
import org.w3c.dom.css.Counter;

public class StrList implements ListOfStrings{

  private Integer listSize;
  private String[] container;
  private static final Integer INITIAL_CAPACITY = 10;

  public StrList(Integer listSize, String[] container) {
    this.listSize = listSize;
    this.container = container;
  }

  public StrList() {
    this.listSize = 0;
    this.container = new String[INITIAL_CAPACITY];

  }

  @Override
  public Boolean isEmpty() {
    return (this.listSize.equals(0));
  }

  @Override
  public Integer size() {
    return this.listSize;
  }

  @Override
  public Boolean contains(String element) {
    for(int index = 0; index < this.listSize; index++) {
      if(this.container[index].equals(element))
        return Boolean.TRUE;
    }
    return Boolean.FALSE;

  }

  @Override
  public Boolean containsAll(String[] elements) {
    int counter =0;
    for(int outerIndex = 0; outerIndex < elements.length; outerIndex ++) {
      for(int innerIndex =0; innerIndex <this.listSize; innerIndex++) {
        if(this.container[innerIndex].equals(elements[outerIndex])) {
            counter++;
            break;
        }
      }

    }
    return counter==elements.length;
  }

  private String getElement(Integer index){
    if(index >=0 && index <= this.listSize) {
      return this.container[index];
    }
    return null;
  }

  @Override
  public ListOfStrings filterLargerThan(Integer largerThanBound) {
    String[] newArray = new String[this.listSize];
    int newArrayIndex = 0;
    for(int index = 0; index < this.listSize; index++){
      if(this.container[index].length() > largerThanBound) {
        newArray[newArrayIndex] = container[index];
        newArrayIndex++;
      }
    }
    this.container = newArray;
    this.listSize = newArrayIndex;
    return new StrList(newArrayIndex, newArray);
  }

  @Override
  public Boolean hasDuplicates() {
    return null;
  }

  @Override
  public ListOfStrings removeDuplicates() {
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StrList strList = (StrList) o;
    return Objects.equals(listSize, strList.listSize) && Arrays.equals(container,
        strList.container);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(listSize);
    result = 31 * result + Arrays.hashCode(container);
    return result;
  }
}
