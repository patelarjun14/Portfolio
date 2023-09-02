package Problem1;

//Rice is child of NonPerishable Food item
public class Rice extends NonPerishableFoodItem{

  //Rice class structure
  public Rice(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }
}
