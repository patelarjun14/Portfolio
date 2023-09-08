package Problem2;

public abstract class AbstractSet implements Set {



  @Override
  public Set add(Set element) {
    return new ElementSetNode(element,this);
  }


}
