package Problem3;

public class EmptyNode implements ILinkedList {

  public EmptyNode(){

  }


  @Override
  public Integer count() {
    return 0;
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
    return 0;
  }

  @Override
  public Boolean contains(Integer element) {
    return Boolean.FALSE;
  }

  @Override
  public Boolean contains() {
    return Boolean.FALSE;
  }

  @Override
  public ILinkedList remove(Integer element) {
    return this;
  }
}
