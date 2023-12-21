package Problem3;

public class ElementListOfLists extends AbstractListOfLists {

  private ILinkedList listElement;
  private ListOfList pointerToRest;

  public ElementListOfLists(ILinkedList listElement, ListOfList pointerToRest) {
    this.listElement = listElement;
    this.pointerToRest = pointerToRest;
  }

  public ElementListOfLists(ILinkedList listElement) {
    this.listElement = listElement;
    this.pointerToRest = new EmptyListOfLists();

  }

  public ILinkedList getListElement() {
    return listElement;
  }

  public void setListElement(ILinkedList listElement) {
    this.listElement = listElement;
  }

  public ListOfList getPointerToRest() {
    return pointerToRest;
  }

  public void setPointerToRest(ListOfList pointerToRest) {
    this.pointerToRest = pointerToRest;
  }


  @Override
  public Integer size() {
    return 1 + this.pointerToRest.size();
  }

  @Override
  public Integer length() {
    return this.listElement.count() + this.pointerToRest.length();
  }

  @Override
  public Integer sum() {
    return this.listElement.sumElements() + this.pointerToRest.sum();
  }

  @Override
  public Boolean isEmpty() {
    return null;
  }

  @Override
  public ListOfList removeInteger(Integer element) {
    if(this.listElement.contains(element))
      return new ElementListOfLists(this.listElement.remove(element), this.pointerToRest);
    else
      return new ElementListOfLists(this.listElement, this.pointerToRest.removeInteger(element));
  }

  @Override
  public ListOfList removeAllIntegers(Integer element) {
    if(this.listElement.contains(element))
      return new ElementListOfLists(this.listElement.remove(element), this.pointerToRest.removeInteger(element));
    else
      return new ElementListOfLists(this.listElement, this.pointerToRest.removeAllIntegers(element));
  }
}
