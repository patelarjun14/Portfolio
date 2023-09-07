package Problem1;

import java.util.ArrayList;

public class AcrylicPainting extends Paintings {

  public AcrylicPainting(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName,
      Double askingPrice, Integer daysAailableAuction) {
    super(name, artistCreator, ownerName, askingPrice, daysAailableAuction);
  }


  private static final double NEGATIVEZEROPOINTNINE = -.9;
  private static final int FIVE = 5;


  private static final int ONEHUNDRED = 100;
  private static final int TWOTHOUSANDFIVEHUNDRED = 2500;
  private static final double NEGATIVEPOINTEIGHT = -.8;
  private static final double ZERO = 0.0;


  @Override
  public String toString() {
    return "AcrylicPainting{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", daysAailableAuction=" + daysAailableAuction +
        '}';
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
  public Double paintingAuctionFactor() {
    if((this.daysAailableAuction > ONEHUNDRED) && this.askingPrice > TWOTHOUSANDFIVEHUNDRED){
      return NEGATIVEPOINTEIGHT;
    }
    else{
      return ZERO;
    }
  }


  @Override
  public Double calculateStartingBid() {
    return (this.askingPrice)*(1.02 + this.photoOwnedFactor() +this.paintingAuctionFactor());
  }


}
