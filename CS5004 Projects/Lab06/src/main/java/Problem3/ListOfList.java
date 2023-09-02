package Problem3;

public interface ListOfList {

  Integer size();
  Integer length();
  Integer sum();
  Boolean isEmpty();
  ListOfList add(ILinkedList list);
  ListOfList removeInteger(Integer element);
  ListOfList removeAllIntegers(Integer element);

}
