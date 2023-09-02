package Problem1;


//Pasta is child of NonPerishable food item
public class Pasta extends NonPerishableFoodItem{

  //Create pasta class structure
  public Pasta(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }
}
