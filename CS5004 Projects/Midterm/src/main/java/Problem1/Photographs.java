package Problem1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Photographs extends ArtPieces{
  public String make;
  public String model;

  public Photographs(String name, ArrayList<Name> artistCreator, ArrayList<Name> ownerName, Double askingPrice,
      String make, String model) {
    super(name, artistCreator, ownerName, askingPrice);
    this.make = make;
    this.model = model;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
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
    Photographs that = (Photographs) o;
    return Objects.equals(make, that.make) && Objects.equals(model, that.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), make, model);
  }

  @Override
  public String toString() {
    return "Photographs{" +
        "name='" + name + '\'' +
        ", artistCreator=" + artistCreator +
        ", ownerName=" + ownerName +
        ", askingPrice=" + askingPrice +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        '}';
  }

  public abstract Double cameraModelFactor();

  public abstract Double photoOwnedFactor();


  @Override
  public abstract Double calculateStartingBid();
}
