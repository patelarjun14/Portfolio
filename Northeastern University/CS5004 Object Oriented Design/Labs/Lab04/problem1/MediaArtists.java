package problem1;

import java.util.Arrays;

public abstract class MediaArtists extends AbstractArtist{
  protected String[] movies;
  protected String[] series;
  protected String[] otherMultiMedia;

  public MediaArtists(Name artistName, Integer age, String[] genres, Award[] award,
      String[] movies, String[] series, String[] otherMultiMedia) {
    super(artistName, age, genres, award);
    this.movies = movies;
    this.series = series;
    this.otherMultiMedia = otherMultiMedia;
  }

  public String[] getMovies() {
    return movies;
  }

  public String[] getSeries() {
    return series;
  }

  public String[] getOtherMultiMedia() {
    return otherMultiMedia;
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
    MediaArtists that = (MediaArtists) o;
    return Arrays.equals(movies, that.movies) && Arrays.equals(series,
        that.series) && Arrays.equals(otherMultiMedia, that.otherMultiMedia);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(movies);
    result = 31 * result + Arrays.hashCode(series);
    result = 31 * result + Arrays.hashCode(otherMultiMedia);
    return result;
  }

  @Override
  public String toString() {
    return "MediaArtists{" +
        "movies=" + Arrays.toString(movies) +
        ", series=" + Arrays.toString(series) +
        ", otherMultiMedia=" + Arrays.toString(otherMultiMedia) +
        '}';
  }
}
