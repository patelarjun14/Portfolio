package problem1.Functionality;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.Csv;
import problem1.Todo;
import problem1.TodoList;

class WriteCsvTest {
  WriteCsv testWriteCsv;
  ArrayList<ArrayList<String>> originalData;

  String filePath = new File("").getAbsolutePath();
  String testCsvFilePath = filePath + "/src/test/java/testFiles/todos.csv";
  String emptyFilePath = filePath + "/src/test/java/testFiles/empty.csv";

  @BeforeEach
  void setUp() {
    testWriteCsv = new WriteCsv(testCsvFilePath);
    originalData = testWriteCsv.csv.getData();
  }

  @AfterEach
  void tearDown() {
    // Reset test file to its original state
    testWriteCsv.csv.setData(originalData);
    testWriteCsv.csv.writeData();
  }

  @Test
  void constructor() {
    assertEquals(testWriteCsv.csv.pathToFile, testCsvFilePath);
  }

  @Test
  void write() {
    TodoList testList = new TodoList();
    testList.add(new Todo(1, "test description", Boolean.FALSE, null, null, null));

    assertDoesNotThrow(() -> {
      testWriteCsv.write(testList);
    });

    WriteCsv clonedWriteCsv = testWriteCsv;
    ArrayList<String> testRow = new ArrayList();
    testRow.add("a");
    ArrayList<ArrayList<String>> testData = new ArrayList();
    testData.add(testRow);

    clonedWriteCsv.csv.setData(testData);
    clonedWriteCsv.csv.columnIndices = new HashMap();
    assertDoesNotThrow(() -> {
      clonedWriteCsv.write(testList);
    });

    testWriteCsv = new WriteCsv(emptyFilePath);
    assertDoesNotThrow(() -> {
      testWriteCsv.write(testList);
    });
  }
}