package problem1.Functionality;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import problem1.Todo;
import problem1.TodoList;

/**
 * Class that adds todos from the command line
 */
public class AddTodo  implements Functionality{
  public TodoList list;

  /**
   * Constructor for the AddTodo class.
   * @param list list of Todos.
   */
  public AddTodo(TodoList list) {
    this.list = list;
  }

  /**
   * Runs Functionality
   * @param arguments HashMap representation of arguments from user input
   */
  public void run(HashMap<String, ArrayList<String>> arguments) {
    Integer id = list.getSize() + 1;
    String text = arguments.get("todo-text").get(0);

    // Optional parameters
    Boolean completed = arguments.containsKey("completed");

    // Due date handling
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    LocalDate dueDate = arguments.get("due") != null ? LocalDate.parse(arguments.get("due").get(0), formatter) : null;

    // Priority handling
    ArrayList<String> rawPriorityValue = arguments.get("priority");
    // Set priority to null and let Todo apply default priority
    Integer priority = rawPriorityValue != null ? Integer.parseInt(rawPriorityValue.get(0)): null;

    // Category handling
    String category = arguments.containsKey("category") ? arguments.get("category").get(0) : null;

    Todo newTodo = new Todo(id, text,completed,dueDate,priority, category);

    list.add(newTodo);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "AddTodo{}";
  }
}