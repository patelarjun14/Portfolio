package Problem3;

import java.util.List;

public abstract class AbstractListOfLists implements ListOfList {


  @Override
  public ListOfList add(ILinkedList list) {
    return new ElementListOfLists(list, this);
  }


}
