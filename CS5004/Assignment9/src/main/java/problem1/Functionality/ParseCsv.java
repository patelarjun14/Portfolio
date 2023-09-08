package problem1.Functionality;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import problem1.Csv;
import problem1.Todo;
import problem1.TodoList;

/**
 * Class that parses a CSV.
 */
public class ParseCsv{
  public String pathToFile;
  public Csv csv;

  /**
   * Constructor for the ParseCsv class.
   * @param pathToFile path to CSV file.
   */
  public ParseCsv(String pathToFile){
    this.pathToFile = pathToFile;
    this.csv = new Csv(pathToFile);
  }

  /**
   * Create a TodoList from the CSV.
   * @return - theTodo list
   */
  public TodoList createTodoList(){
    TodoList list = new TodoList();

    if (this.csv != null) {
      ArrayList<ArrayList<String>> data = this.csv.getData();
      for (int i = 1; i < data.size() ; i++) {
        String text = this.csv.getValue(i, "text");
        Boolean completed = Boolean.parseBoolean(this.csv.getValue(i, "completed"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        String rawDueDateValue = this.csv.getValue(i, "due");
        LocalDate due =
            rawDueDateValue != null ? LocalDate.parse(rawDueDateValue, formatter) : null;
        String rawPriorityValue = this.csv.getValue(i, "priority");
        Integer priority = rawPriorityValue != null ? Integer.parseInt(rawPriorityValue) : null;
        String category = this.csv.getValue(i, "category");

        Todo newTodo = new Todo(i, text, completed, due, priority, category);
        list.add(newTodo);
      }
    }

    return list;
  }

  /**
   * Returns path to CSV file.
   * @return path to CSV file.
   */
  public String getPathToFile() {
    return this.pathToFile;
  }

  /**
   * returns Csv.
   * @return Csv object generated from CSV file.
   */
  public Csv getCsv() {
    return this.csv;
  }
}