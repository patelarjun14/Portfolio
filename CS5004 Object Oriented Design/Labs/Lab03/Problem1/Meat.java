package Problem1;

import java.time.LocalDateTime;

//Meat is child of Perishable food item
public class Meat extends PerishableFoodItem {

  // create meat class structure
  public Meat(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity, orderDate, expirationDate);
  }
}
