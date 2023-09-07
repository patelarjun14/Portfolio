package Problem1;


//Nonperishable food item is child of Food item
public abstract class NonPerishableFoodItem extends FoodItem {

  public NonPerishableFoodItem(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity);
  }
}
