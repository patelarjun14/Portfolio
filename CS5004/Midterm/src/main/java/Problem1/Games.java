package Problem1;

import java.util.ArrayList;

public class Games extends NFTs {

  public Games(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      Integer daysAvailableAuction, String standardCrypto) {
    super(name, artistCreator, ownerName, askingPrice, daysAvailableAuction, standardCrypto);
  }

  @Override
  public String toString() {
    return "Games{" +
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
