package problem1;

import java.util.Objects;

public class Poet extends AbstractArtist{
  private String publishedCompany;
  private String lastPublisnedCollection;

  public Poet(Name artistName, Integer age, String[] genres, Award[] award,
      String publishedCompany, String lastPublisnedCollection) {
    super(artistName, age, genres, award);
    this.publishedCompany = publishedCompany;
    this.lastPublisnedCollection = lastPublisnedCollection;
  }

  public String getPublishedCompany() {
    return publishedCompany;
  }

  public String getLastPublisnedCollection() {
    return lastPublisnedCollection;
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
    Poet poet = (Poet) o;
    return Objects.equals(publishedCompany, poet.publishedCompany)
        && Objects.equals(lastPublisnedCollection, poet.lastPublisnedCollection);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), publishedCompany, lastPublisnedCollection);
  }

  @Override
  public String toString() {
    return "Poet{" +
        "publishedCompany='" + publishedCompany + '\'' +
        ", lastPublisnedCollection='" + lastPublisnedCollection + '\'' +
        '}';
  }
}
