package Problem3;

public interface ILinkedList {

  Integer count();

  Integer getItem();

  ILinkedList getRest();

  ILinkedList inset(Integer Item);

  ILinkedList insertAt(Integer item, Integer index) throws IndexOutOfBoundsException;

  Integer sumElements();

  Boolean contains(Integer element);

  Boolean contains();

  ILinkedList remove(Integer element);


}
