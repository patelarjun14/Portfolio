package Problem2;

import java.util.ArrayList;
import java.util.Objects;

public class Book extends Item{
  Author author;

  public Book(String titleOfItem, Integer itemYear, Author author) {
    super(titleOfItem, itemYear);
    this.author = author;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
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
    Book book = (Book) o;
    return Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), author);
  }

  @Override
  public String toString() {
    return "Book{" +
        "author=" + author +
        ", titleOfItem='" + titleOfItem + '\'' +
        ", itemYear=" + itemYear +
        '}';
  }

  @Override
  public Author getAuthorItem() {
    return this.author;
  }

  @Override
  public ArrayList<RecordingArtist> getRecordingArtistItem() {
    return new ArrayList<RecordingArtist>();
  }


}
