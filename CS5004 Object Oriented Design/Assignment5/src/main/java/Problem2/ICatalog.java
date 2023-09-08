package Problem2;

import java.util.ArrayList;

public interface ICatalog {

  /**
   * @param keyword Place in key word you would like to search
   * @return all title of items in a string list
   */
  ArrayList<String> search(String keyword);


  /**
   * @param author Author of item
   * @return Only books with that author (returned as an object)
   */
  Author search(Author author);


  /**
   * @param recordingartist Name of recording artist
   * @return a list of items with the recording artist
   */
  ArrayList<Item> search(RecordingArtist recordingartist);


  /**
   * @param item what item you would like to remove
   * @return Adds an item to the Catalog
   */
  Object addItem(Item item);


  /**
   * @param item
   * @return removes an item from the catalog
   */
  Object remove(Item item);


}
