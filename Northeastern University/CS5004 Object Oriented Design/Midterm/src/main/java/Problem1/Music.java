package Problem1;

import java.util.ArrayList;

public class Music extends NFTs{

  public Music(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      Integer daysAvailableAuction, String standardCrypto) {
    super(name, artistCreator, ownerName, askingPrice, daysAvailableAuction, standardCrypto);
  }

  @Override
  public String toString() {
    return "Music{" +
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
    return null;
  }



}
