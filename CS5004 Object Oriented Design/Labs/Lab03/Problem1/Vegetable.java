package Problem1;

import java.time.LocalDateTime;

//Vegetable is child of Perishable Food Item
public class Vegetable extends PerishableFoodItem {

  //Create class structure for vegetable
  public Vegetable(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity, orderDate, expirationDate);
  }
}
