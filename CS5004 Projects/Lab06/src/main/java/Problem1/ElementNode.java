package Problem1;

import java.util.Objects;

public class ElementNode implements  ListOfIntegers{

  private Integer elementValue;
  private ListOfIntegers pointToRest;

  public ElementNode(Integer elementValue, ListOfIntegers pointToRest) {
    this.elementValue = elementValue;
    this.pointToRest = pointToRest;
  }

  public ElementNode(Integer elementValue){
    this.elementValue = elementValue;
    this.pointToRest = new EmptyNode();
  }

  public Integer getElementValue() {
    return elementValue;
  }

  public void setElementValue(Integer elementValue) {
    this.elementValue = elementValue;
  }

  public ListOfIntegers getPointToRest() {
    return pointToRest;
  }

  public void setPointToRest(ListOfIntegers pointToRest) {
    this.pointToRest = pointToRest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementNode that = (ElementNode) o;
    return Objects.equals(elementValue, that.elementValue) && Objects.equals(
        pointToRest, that.pointToRest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementValue, pointToRest);
  }


  @Override
  public Boolean contains(Integer element) {
    if(this.elementValue.equals(element)){
      return Boolean.TRUE;
    }
    else {
      return this.pointToRest.contains(element);
    }
  }

  @Override
  public Integer elementAt(Integer index) throws IndexOutOfBoundsException{
    if(index < 0 || index > this.count())
      throw new IndexOutOfBoundsException("This list of integers is empty!");
    else if(index.equals(0))
      return this.elementValue;
    else return this.pointToRest.elementAt(index);
  }

  @Override
  public Integer count() {
    return 1 + this.pointToRest.count();
  }
}
