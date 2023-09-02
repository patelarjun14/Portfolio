package Problem1;

import java.time.LocalDateTime;

//Fruit is child of perishable food item
public class Fruit extends PerishableFoodItem{

  //Create fruit Class structure
  public Fruit(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity, orderDate, expirationDate);
  }
}
