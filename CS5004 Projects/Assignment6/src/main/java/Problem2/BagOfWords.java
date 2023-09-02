package Problem2;

/**
 *  This is an interface for BagOfWords
 */
public interface BagOfWords {

  /**
   * @return An EmptyBagOfWords
   */
  static BagOfWords emptyBagOfWords(){
    return new EmptyBagOfWords();
  }

  /**
   * @return A Boolean
   * This checks to see if a BagOfWords is empty
   */
  Boolean isEmpty();

  /**
   * @return An Integer
   * This will return the size of a BagOfWords (number of elements)
   */
  Integer size();


  /**
   * @param s A string
   * @return A BagOfWords with added string
   * This will return the all the elements within the BagOfWords
   */
  BagOfWords add(String s);


  /**
   * @param s A string
   * @return A boolean
   * This will state whether the entered string is within the BagOfWords
   */
  Boolean contains(String s);

}
