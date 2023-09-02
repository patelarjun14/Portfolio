package Problem1;

import java.util.ArrayList;

public class Meme extends NFTs{

  public Meme(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      Integer daysAvailableAuction, String standardCrypto) {
    super(name, artistCreator, ownerName, askingPrice, daysAvailableAuction, standardCrypto);
  }

  private static final int SIXTY = 60;
  private static final double NEGATIVEPOINTSEVEN = -.7;
  private static final double ZERO = 0.0;

  private static final int FIFTEEN = 15;
  private static final double NEGATIVEZEROPOINTSEVENFIVE = -0.75;



  @Override
  public String toString() {
    return "Meme{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", daysAvailableAuction=" + daysAvailableAuction +
        ", standardCrypto='" + standardCrypto + '\'' +
        '}';
  }

  @Override
  public Double nftAuctionDaysFactor() {
        if((this.daysAvailableAuction > SIXTY) && (this.standardCrypto == "ERC-721")) {
      return NEGATIVEPOINTSEVEN;
    }
    else{
      return ZERO;
    }

  }


  public Double memeAuctionDayFactor(){
    if(this.daysAvailableAuction > FIFTEEN){
      return NEGATIVEZEROPOINTSEVENFIVE;
    }
    else{
      return ZERO;
    }
  }

  @Override
  public Double calculateStartingBid() {
    return (this.askingPrice)*(1.02+ this.nftAuctionDaysFactor());
  }



}
