package Problem2;

public class EmptySetNode extends AbstractSet{

  protected EmptySetNode(){




  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Set add(Integer element) {
    return null;
  }

  @Override
  public Boolean contains(Integer element) {
    return Boolean.FALSE;
  }

  @Override
  public Set remove(Integer element) {
    throw new IllegalArgumentException("The give element cannot be removed!");
  }

  @Override
  public Integer size() {
    return 0;
  }
}
