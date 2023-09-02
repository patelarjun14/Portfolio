package Problem2;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {
  private Catalog testCatalog;
  private Catalog testCatalog2;
  private ArrayList<Item> catalogList;
  private ArrayList<Item> catalogList2;
  private Author testAuthor;

  private Band testBand;

  private ArrayList<RecordingArtist> testList;

  private Book item1;
  private Music item2;
  private Book item3;
  private Music item4;
  private Book item5;

  private RecordingArtist person1;
  private RecordingArtist person2;
  private RecordingArtist person3;
  private RecordingArtist person4;
  private RecordingArtist person5;

  @BeforeEach
  void setUp() {

    testAuthor = new Author("Arjun","Patel");


    person1 = new RecordingArtist("Zrjun","Patel");
    person2 = new RecordingArtist("John","Wick");
    person3 = new RecordingArtist("Steve","Jobs");
    person4 = new RecordingArtist("Snoop","Dog");
    person5 = new RecordingArtist("Kakashi","Hatake");

    testList = new ArrayList<RecordingArtist>();
    testList.add(person1);
    testList.add(person2);
    testList.add(person3);
    testList.add(person4);
    testList.add(person5);

    testBand = new Band(testList,"CrazyLightning");

    item1 = new Book("Why Dogs are Better",2012,testAuthor);

    item2 = new Music("Hello Sun",1956,testBand);



    catalogList = new ArrayList<>();
    catalogList2 = new ArrayList<>();

    catalogList.add(item1);
    catalogList.add(item2);

    catalogList2.add(item1);


    testCatalog = new Catalog(catalogList);

    testCatalog2= new Catalog(catalogList2);

  }

  @Test
  void getCatalogList() {
    assertEquals(catalogList2,testCatalog2.getCatalogList());


  }

  @Test
  void setCatalogList() {
    testCatalog.setCatalogList(catalogList2);
    assertEquals(catalogList2,testCatalog.getCatalogList());
  }

  @Test
  void search() {
    ArrayList<String> x = new ArrayList<>();
    x.add(item1.titleOfItem);
    assertEquals(x,testCatalog2.search("h"));
}

  @Test
  void testSearch() {

  }

  @Test
  void testSearch1() {
  }

  @Test
  void addItem() {
    assertEquals(catalogList,testCatalog2.addItem(item2));
  }

  @Test
  void remove() {
    assertEquals(catalogList2,testCatalog.remove(item2));
  }
}