package problem1.Functionality;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import problem1.TodoApp;

class DisplayTodosTest {

  TodoApp app = new TodoApp();
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

  String[] test2Args = {
      "--csv-file", testCsv,
      "--add-todo",
      "--todo-text", "Test todo",
      "--completed",
      "--due", "3/21/2022",
      "--priority", "2",
      "--display",
      "--sort-by-priority"
  };

  String[] test3Args = {
      "--csv-file", testCsv,
      "--add-todo",
      "--todo-text", "Test todo",
      "--completed",
      "--due", "3/21/2022",
      "--priority", "2",
      "--display",
      "--sort-by-date"
  };

  @BeforeEach
  void setUp() {
  }

  @Test
  void run() {
    app.run(testArgs);
    app.run(test2Args);
    app.run(test3Args);
  }
}