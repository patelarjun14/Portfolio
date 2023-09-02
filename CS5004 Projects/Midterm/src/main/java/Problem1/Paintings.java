package Problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Paintings extends ArtPieces {
  public Integer daysAailableAuction;


  public Paintings(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      Integer daysAailableAuction) {
    super(name, artistCreator, ownerName, askingPrice);
    this.daysAailableAuction = daysAailableAuction;
  }

  public Integer getDaysAailableAuction() {
    return daysAailableAuction;
  }

  public void setDaysAailableAuction(Integer daysAailableAuction) {
    this.daysAailableAuction = daysAailableAuction;
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
    Paintings paintings = (Paintings) o;
    return Objects.equals(daysAailableAuction, paintings.daysAailableAuction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), daysAailableAuction);
  }

  @Override
  public String toString() {
    return "Paintings{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", daysAailableAuction=" + daysAailableAuction +
        '}';
  }


  @Override
  public abstract Double calculateStartingBid();

  public abstract Double photoOwnedFactor();

  public abstract Double paintingAuctionFactor();




}
