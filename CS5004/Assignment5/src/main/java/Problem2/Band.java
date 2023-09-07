package Problem2;

import java.util.ArrayList;
import java.util.Objects;

public class Band extends Group{
  public String band;

  public Band(ArrayList<RecordingArtist> people, String band) {
    super(people);
    this.band = band;
  }

  public String getBand() {
    return band;
  }

  public void setBand(String band) {
    this.band = band;
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
    Band band1 = (Band) o;
    return Objects.equals(band, band1.band);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), band);
  }


  @Override
  public String toString() {
    return "Band{" +
        "band='" + band + '\'' +
        ", people=" + people +
        '}';
  }
}
