package problem1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractArtist implements Artist{
  protected Name artistName;
  protected Integer age;
  protected String[] genres;
  protected Award[] award;

  public AbstractArtist(Name artistName, Integer age, String[] genres, Award[] award) {
    this.artistName = artistName;
    this.age = age;
    this.genres = genres;
    this.award = award;
  }

  public Name getArtistName() {
    return artistName;
  }

  public Integer getAge() {
    return age;
  }

  public String[] getGenres() {
    return genres;
  }

  public Award[] getAward() {
    return award;
  }
  @Override
  public Boolean receiveAward(String award) {
    if(award!= null) {
      Award myAward = new Award(award, "Award category", "Award comittee", LocalDate.now());
      this.award[this.award.length] = myAward;
      return Boolean.TRUE;
    }
    else return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractArtist that = (AbstractArtist) o;
    return Objects.equals(artistName, that.artistName) && Objects.equals(age,
        that.age) && Arrays.equals(genres, that.genres) && Arrays.equals(award,
        that.award);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(artistName, age);
    result = 31 * result + Arrays.hashCode(genres);
    result = 31 * result + Arrays.hashCode(award);
    return result;
  }

  @Override
  public String toString() {
    return "AbstractArtist{" +
        "artistName=" + artistName +
        ", age=" + age +
        ", genres=" + Arrays.toString(genres) +
        ", award=" + Arrays.toString(award) +
        '}';
  }



}
