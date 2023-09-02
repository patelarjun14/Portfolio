package Problem2;

/**
 * This is an abstract class for Queue
 */
public abstract class Queue implements BagOfWords {

  /**
   * @param s A string
   * @return A new BagOfWords
   * After adding a string to the BagOfWords, this
   * will create a new BagOfWords with the added
   * string
   */
  @Override
  public BagOfWords add(String s){
    return new ConsBagOfWords(s, this);
  }




}
