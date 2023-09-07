package Problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class NFTs extends ArtPieces{
  public Integer daysAvailableAuction;
  public String standardCrypto;

  public NFTs(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      Integer daysAvailableAuction, String standardCrypto) {
    super(name, artistCreator, ownerName, askingPrice);
    this.daysAvailableAuction = daysAvailableAuction;
    this.standardCrypto = standardCrypto;
  }

  public Integer getDaysAvailableAuction() {
    return daysAvailableAuction;
  }

  public void setDaysAvailableAuction(Integer daysAvailableAuction) {
    this.daysAvailableAuction = daysAvailableAuction;
  }

  public String getStandardCrypto() {
    return standardCrypto;
  }

  public void setStandardCrypto(String standardCrypto) {
    this.standardCrypto = standardCrypto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    NFTs nfTs = (NFTs) o;
    return Objects.equals(daysAvailableAuction, nfTs.daysAvailableAuction)
        && Objects.equals(standardCrypto, nfTs.standardCrypto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), daysAvailableAuction, standardCrypto);
  }

  @Override
  public String toString() {
    return "NFTs{" +
        "artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", daysAvailableAuction=" + daysAvailableAuction +
        ", standardCrypto='" + standardCrypto + '\'' +
        '}';
  }


  public abstract Double nftAuctionDaysFactor();
//    if((this.daysAvailableAuction > SIXTY) && (this.standardCrypto == "ERC-721")) {
//      return NEGATIVEPOINTSEVEN;
//    }
//    else{
//      return ZERO;
//    }
//
//  }

  @Override
  public Double calculateStartingBid() {
    return null;
  }




}
