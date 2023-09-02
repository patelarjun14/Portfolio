package Problem2;

import java.util.ArrayList;
import java.util.Objects;

abstract class Item {
  public String titleOfItem;
  public Integer itemYear;

  public Item(String titleOfItem, Integer itemYear) {
    this.titleOfItem = titleOfItem;
    this.itemYear = itemYear;
  }

  public String getTitleOfItem() {
    return titleOfItem;
  }

  public void setTitleOfItem(String titleOfItem) {
    this.titleOfItem = titleOfItem;
  }

  public Integer getItemYear() {
    return itemYear;
  }

  public void setItemYear(Integer itemYear) {
    this.itemYear = itemYear;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(titleOfItem, item.titleOfItem) && Objects.equals(
        itemYear, item.itemYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titleOfItem, itemYear);
  }


  @Override
  public String toString() {
    return "Item{" +
        "titleOfItem='" + titleOfItem + '\'' +
        ", itemYear=" + itemYear +
        '}';
  }


  public abstract Author getAuthorItem();

  public abstract ArrayList<RecordingArtist> getRecordingArtistItem();

}




