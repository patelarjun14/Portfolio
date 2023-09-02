package Problem2;

import Problem1.EmptyQueue;

/**
 * This is a class for an empty BagOfWords
 */
public class EmptyBagOfWords extends Queue {

  /**
   * Assigning Hashcode for EmptyBagOfWords
   */
  private static final int HASH_CODE = 24123;
  private static final int ZERO = 0;

  /**
   * @return Boolean
   * This is always true because this is an EmptyBagOfWords
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * @return Integer
   * This always returns a zero because this is an EmptyBagOfWords
   */
  @Override
  public Integer size() {
    return ZERO;
  }

  /**
   * @param s A string
   * @return Boolean
   * This is always false because this is an EmptyBagOfWords
   */
  @Override
  public Boolean contains(String s) {
    return false;
  }


  /**
   * @return Integer for HASH_CODE
   * returns assigned HASH_CODE
   */
  @Override
  public int hashCode() {
    return EmptyBagOfWords.HASH_CODE;
  }

  /**
   * @param obj object
   * @return boolean
   * States whether if two objects are the same
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof EmptyBagOfWords)) {
      return false;
    }
    return true;
  }



}
