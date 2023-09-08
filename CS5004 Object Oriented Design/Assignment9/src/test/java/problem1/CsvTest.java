package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CsvTest {
  public Csv testCsv;

  String filePath = new File("").getAbsolutePath();
  String testCsvFilePath = filePath + "/src/main/java/problem1/todos.csv";

  @BeforeEach
  void setUp() {
    testCsv = new Csv(testCsvFilePath);
  }

  @Test
  void addRow() {
    HashMap<String, String> testData = new HashMap();

    testData.put("id", "10");
    testData.put("text", "test");
    testData.put("no index", "none");

    testCsv.addRow(testData);
    Integer lastIndex = testCsv.getData().size() - 1;

    ArrayList<String> lastRow = testCsv.getData().get(lastIndex);
    assertEquals(lastRow.get(0), "10");
    assertEquals(lastRow.get(1), "test");
    assertEquals(lastRow.get(2), "?");
  }

  @Test
  void getRow() {
    HashMap<String, String> testData = new HashMap();

    testData.put("id", "10");
    testData.put("text", "test");

    testCsv.addRow(testData);

    Integer lastIndex = testCsv.getData().size() - 1;
    assertEquals(testCsv.getRow("id", "100"), -1);
    assertEquals(testCsv.getRow("nothing", ""), -1);
  }

  @Test
  void getColumnIndex() {
    assertEquals(testCsv.getColumnIndex("id"), 0);
  }

  @Test
  void getColumns() {
    ArrayList<String> columns = new ArrayList(testCsv.columnIndices.keySet());
    assertEquals(testCsv.getColumns(), columns);
  }

  @Test
  void getValue() {
    HashMap<String, String> testData = new HashMap();

    testData.put("id", "10");
    testData.put("text", "");

    testCsv.addRow(testData);

    Integer lastIndex = testCsv.getData().size() - 1;

    assertEquals(testCsv.getValue(lastIndex, "id"), "10");
    assertEquals(testCsv.getValue(lastIndex, "text"), null);
    assertEquals(testCsv.getValue(lastIndex, "nothing"), null);
    assertEquals(testCsv.getValue(lastIndex, "priority"), null);
  }

  @Test
  void setValue() {
    HashMap<String, String> testData = new HashMap();

    testData.put("id", "10");
    testData.put("text", "");

    testCsv.addRow(testData);

    Integer lastIndex = testCsv.getData().size() - 1;
    assertEquals(testCsv.getValue(lastIndex, "text"), null);
    testCsv.setValue(lastIndex, "text", "test todo");
    assertEquals(testCsv.getValue(lastIndex, "text"), "test todo");
    testCsv.setValue(lastIndex, "hello", "world");
    assertEquals(testCsv.getValue(lastIndex, "hello"), null);
  }

  @Test
  void testEquals() {
    Csv testSameCsv = new Csv(testCsvFilePath);
    assertTrue(testCsv.equals(testCsv));
    assertTrue(testCsv.equals(testSameCsv));

    Csv clonedCsv = new Csv(testCsvFilePath);
    clonedCsv.pathToFile = "path";
    assertFalse(testCsv.equals(clonedCsv));

    clonedCsv = new Csv(testCsvFilePath);
    clonedCsv.data = new ArrayList();
    assertFalse(testCsv.equals(clonedCsv));

    clonedCsv = new Csv(testCsvFilePath);
    clonedCsv.columnIndices = new HashMap();
    assertFalse(testCsv.equals(clonedCsv));
    assertFalse(testCsv.equals(null));
    assertFalse(testCsv.equals(new ArrayList<String>()));
  }

  @Test
  void testHashCode() {
    Csv testSameCsv = new Csv(testCsvFilePath);
    assertTrue(testCsv.equals(testSameCsv) && testSameCsv.equals(testCsv));
    assertTrue(testCsv.hashCode() == testSameCsv.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Csv{" +
        "pathToFile='" + testCsvFilePath + '\'' +
        "content='" + testCsv.getDataAsString() + "'" +
        '}';
    assertEquals(expectedString, testCsv.toString());
  }
}