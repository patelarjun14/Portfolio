package Problem1;

import java.util.ArrayList;

public class Lifestyle extends Photographs{

  public Lifestyle(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      String make, String model) {
    super(name, artistCreator, ownerName, askingPrice, make, model);
  }
  private static final double ONEPOINTTHREEFIVE = 1.35;
  private static final double ZERO = 0.0;

  private static final double NEGATIVEZEROPOINTNINE = -.9;
  private static final int FIVE = 5;



  @Override
  public String toString() {
    return "Lifestyle{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        '}';
  }

  @Override
  public Double cameraModelFactor() {
    if((this.model == "Canon") && (this.make == "EOS R5")){
      return ONEPOINTTHREEFIVE;
    }
    else{
      return ZERO;
    }

  }

  @Override
  public Double photoOwnedFactor() {
    if(this.ownerName.size()>FIVE) {
      return NEGATIVEZEROPOINTNINE;
    }
    else{
      return ZERO;
    }
  }

  @Override
  public Double calculateStartingBid() {
    return (this.askingPrice)*(1.02 + this.cameraModelFactor());
  }
}
