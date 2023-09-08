package Problem2;

import java.util.ArrayList;
import java.util.Objects;

public class Music extends Item{
  public Band band;

  public Music(String titleOfItem, Integer itemYear, Band band) {
    super(titleOfItem, itemYear);
    this.band = band;
  }

  public Band getBand() {
    return band;
  }

  public void setBand(Band band) {
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
    Music music = (Music) o;
    return Objects.equals(band, music.band);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), band);
  }

  @Override
  public String toString() {
    return "Music{" +
        "titleOfItem='" + titleOfItem + '\'' +
        ", itemYear=" + itemYear +
        ", band=" + band +
        '}';
  }

  @Override
  public Author getAuthorItem() {
    return new Author("","");
  }


  @Override
  public ArrayList<RecordingArtist> getRecordingArtistItem() {
    ArrayList<RecordingArtist> list = this.getBand().people;
    ArrayList<RecordingArtist> newList = new ArrayList<>();
    for(RecordingArtist s: list) {
      newList.add(s);
    }
    return newList;
  }


}
