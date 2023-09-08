package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoAppTest {
  TodoApp testApp;
  Csv originalCsv;

  String filePath = new File("").getAbsolutePath();
  String testCsv = filePath + "/src/test/java/testFiles/todos.csv";

  String[] testArgs = {
      "--csv-file", testCsv,
      "--add-todo",
      "--todo-text", "Test todo",
      "--completed",
      "--due", "3/21/2022",
      "--priority", "2",
      "--display",
      "--show-incomplete",
      "--show-category", "home",
      "--sort-by-date",
      "--complete-todo", "2",
      "--complete-todo", "3"
  };

  @BeforeEach
  void setUp() {
    testApp = new TodoApp();
    originalCsv = testApp.cachedCsv;
  }

  @AfterEach
  void tearDown() {
    if (originalCsv != null) {
      originalCsv.writeData();
    }
  }

  @Test
  void run() {
    testApp.run(testArgs);

    String newPath = filePath + "/src/test/java/testFiles/empty.csv";
    String[] newArgs = {
        "--csv-file", newPath,
        "--display",
    };

    assertDoesNotThrow(() -> {
      testApp.run(newArgs);
    });
  }
}