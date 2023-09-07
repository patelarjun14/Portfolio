package Problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ArtPieces {
  public String name;
  public ArrayList<Name> artistCreator;
  public ArrayList<Name> ownerName;
  public Double askingPrice;

  public ArtPieces(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice) {
    this.name = name;
    this.artistCreator = artistCreator;
    this.ownerName = ownerName;
    this.askingPrice = askingPrice;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Name> getArtistCreator() {
    return artistCreator;
  }

  public void setArtistCreator(ArrayList<Name> artistCreator) {
    this.artistCreator = artistCreator;
  }

  public ArrayList<Name> getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(ArrayList<Name> ownerName) {
    this.ownerName = ownerName;
  }

  public Double getAskingPrice() {
    return askingPrice;
  }

  public void setAskingPrice(Double askingPrice) {
    this.askingPrice = askingPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArtPieces artPieces = (ArtPieces) o;
    return Objects.equals(name, artPieces.name) && Objects.equals(artistCreator,
        artPieces.artistCreator) && Objects.equals(ownerName, artPieces.ownerName)
        && Objects.equals(askingPrice, artPieces.askingPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, artistCreator, ownerName, askingPrice);
  }

  @Override
  public String toString() {
    return "ArtPieces{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        '}';
  }



  public abstract Double calculateStartingBid();



}
