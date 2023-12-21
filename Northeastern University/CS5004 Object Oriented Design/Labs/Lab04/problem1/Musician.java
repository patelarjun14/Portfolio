package problem1;

import java.util.Objects;

public class Musician extends AbstractArtist{

  private String recordingCompany;
  private String lastRecordedAlbum;

  public Musician(Name artistName, Integer age, String[] genres, Award[] award,
      String recordingCompany, String lastRecordedAlbum) {
    super(artistName, age, genres, award);
    this.recordingCompany = recordingCompany;
    this.lastRecordedAlbum = lastRecordedAlbum;
  }

  public String getRecordingCompany() {
    return recordingCompany;
  }

  public String getLastRecordedAlbum() {
    return lastRecordedAlbum;
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
    Musician musician = (Musician) o;
    return Objects.equals(recordingCompany, musician.recordingCompany)
        && Objects.equals(lastRecordedAlbum, musician.lastRecordedAlbum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), recordingCompany, lastRecordedAlbum);
  }


  @Override
  public String toString() {
    return "Musician{" +
        "recordingCompany='" + recordingCompany + '\'' +
        ", lastRecordedAlbum='" + lastRecordedAlbum + '\'' +
        '}';
  }
}
