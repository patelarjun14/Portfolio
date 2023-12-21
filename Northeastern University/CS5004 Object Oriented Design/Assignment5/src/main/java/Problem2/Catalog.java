package Problem2;

import java.util.ArrayList;

public class Catalog implements ICatalog{
  public static ArrayList<Item> catalogList;

  public Catalog(ArrayList<Item> catalogList) {
    this.catalogList = catalogList;
  }

  public static ArrayList<Item> getCatalogList() {
    return catalogList;
  }

  public void setCatalogList(ArrayList<Item> catalogList) {
    this.catalogList = catalogList;
  }

  @Override
  public ArrayList<String> search(String keyword) {
    ArrayList<Item> search = new ArrayList<>();
    ArrayList<String> searchstring = new ArrayList<>();
    for(Item s: Catalog.catalogList) {
      if (s.getTitleOfItem().contains(keyword)) {
        search.add(s);
      }
    }
    for(Item i: search){
      searchstring.add(i.getTitleOfItem());
    }
    return searchstring;
  }


  @Override
  public Author search(Author author) {
    ArrayList<Author> search = new ArrayList<>();
    for(Item s: Catalog.catalogList) {
      if(s.getAuthorItem().equals(author)){
        search.add(s.getAuthorItem());
      }
    }
    return author;

  }

  @Override
  public ArrayList<Item> search(RecordingArtist recordingartist) {
    ArrayList<Item> search = new ArrayList<>();
    for (Item s: Catalog.catalogList) {
      for(RecordingArtist x: s.getRecordingArtistItem()){
        if(x == recordingartist){
          search.add(s);
        }
      }
    }
    return search;
  }

  @Override
  public Object addItem(Item item) {
    this.catalogList.add(item);
    return this.catalogList;
  }

  @Override
  public Object remove(Item item) {
    this.catalogList.remove(item);
    return this.catalogList;
  }


}
