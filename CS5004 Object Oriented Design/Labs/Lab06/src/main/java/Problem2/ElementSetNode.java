package Problem2;

public class ElementSetNode extends AbstractSet{
  private Set element;
  private Set pointerToRest;

  public ElementSetNode(Set element, Set pointerToRest) {
    this.element = element;
    this.pointerToRest = pointerToRest;
  }

  public ElementSetNode(Set element) {
    this.element = element;
    this.element = Set.emptySet();
  }

  public Set getElement() {
    return element;
  }

  public void setElement(Set element) {
    this.element = element;
  }

  public Set getPointerToRest() {
    return pointerToRest;
  }

  public void setPointerToRest(Set pointerToRest) {
    this.pointerToRest = pointerToRest;
  }


  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Set add(Integer element) {
    if(this.contains(element))
      return this;
    else return new ElementSetNode(this.element,this);
  }

  @Override
  public Boolean contains(Integer element) {
    if(this.element.equals(element))
      return Boolean.TRUE;
    else return this.pointerToRest.contains(element);
  }

  @Override
  public Set remove(Integer element) {
    if(this.contains(element))
      return this;
    else if(this.element.equals(element)){
      return this.pointerToRest;
    }
    else
      return new ElementSetNode(this.element,this.pointerToRest.remove(element));
  }

  @Override
  public Integer size() {
    return 1 + pointerToRest.size();
  }
}
