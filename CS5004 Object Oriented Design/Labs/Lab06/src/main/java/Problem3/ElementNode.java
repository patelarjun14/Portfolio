package Problem3;

public class ElementNode implements ILinkedList{

  private Integer item;
  private ILinkedList rest;

  public ElementNode(Integer item, ILinkedList rest) {
    this.item = item;
    this.rest = rest;
  }

  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  @Override
  public Integer getItem() {
    return null;
  }

  @Override
  public ILinkedList getRest() {
    return null;
  }

  @Override
  public ILinkedList inset(Integer Item) {
    return null;
  }

  @Override
  public ILinkedList insertAt(Integer item, Integer index) throws IndexOutOfBoundsException {
    return null;
  }

  @Override
  public Integer sumElements() {
    return this.item+this.sumElements();
  }

  @Override
  public Boolean contains(Integer element) {
    if(this.item.equals(element))
      return Boolean.TRUE;
    else return this.rest.contains(element);

  }

  @Override
  public Boolean contains() {
    return null;
  }

  @Override
  public ILinkedList remove(Integer element) {
    if(!this.contains(element))
      return this;
    else if(this.item.equals(element))
      return this.rest;
    else return new ElementNode(this.item,this.rest.remove(element));
  }
}
