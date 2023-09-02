package problem2_arrays;

public interface ListOfStrings {

  Boolean isEmpty();
  Integer size();
  Boolean contains(String element);
  Boolean containsAll(String[] elements);
  ListOfStrings filterLargerThan(Integer largerThanBound);
  Boolean hasDuplicates();
  ListOfStrings removeDuplicates();


}
