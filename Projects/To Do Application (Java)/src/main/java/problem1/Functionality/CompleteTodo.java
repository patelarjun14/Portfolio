package problem1.Functionality;

import java.util.ArrayList;
import java.util.HashMap;
import problem1.TodoList;
import problem1.UnknownTodoException;

/**
 * This is the CompleteTodo class. This class runs the method completeToDo
 */
public class CompleteTodo implements Functionality {
  public TodoList list;

  /**
   * Constructor for the CompleteTodo class.
   * @param list list of Todos.
   */
  public CompleteTodo(TodoList list) {
    this.list = list;
  }

  /**
   * Runs Functionality
   * @param arguments HashMap representation of arguments from user input
   */
  public void run(HashMap<String, ArrayList<String>> arguments){
    ArrayList<String> ids = arguments.get("complete-todo");
    if (ids != null) {
      for (String id : ids) {
        try {
          list.getTodo(Integer.parseInt(id)).setCompleted(Boolean.TRUE);
        } catch(UnknownTodoException e){
          System.out.println(e.getMessage());
        }
      }
    }
  }
}
