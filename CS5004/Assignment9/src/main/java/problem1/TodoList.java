package problem1;

import java.util.*;

/**
 * Class that tracks and updates a list of Todos.
 */
public class TodoList {
  private HashMap<Integer, Todo> list;

  /**
   * Constructor for the TodoList class.
   */
  public TodoList() {
    this.list = new HashMap();
  }

  /**
   * Constructor for the TodoList class.
   * @param list list of Todos encoded as a HashMap.
   */
  public TodoList(HashMap<Integer, Todo> list) {
    this.list = list;
  }

  /**
   * Adds a Todo to the list
   * @param newTodo Todo to be added to the list.
   */
  public void add(Todo newTodo){
    this.list.put(newTodo.getId(), newTodo);
  }

  /**
   * Returns the size of the list.
   * @return Size of the list.
   */
  public Integer getSize() {
    return this.list.size();
  }

  /**
   * Returns the list of Todos.
   * @return List of the Todos encoded as an ArrayList.
   */
  public ArrayList<Todo> getList() {
    return new ArrayList(this.list.values());
  }

  /**
   * Gets a Todo by its ID.
   * @param id ID of the Todo to retrieve.
   * @return Todo object.
   */
  public Todo getTodo(Integer id) throws UnknownTodoException{
    Todo todo = this.list.get(id);

    if (todo == null){
      throw new UnknownTodoException("Cannot complete Todo \"" + id + "\" as it does not exist.");
    }

    return todo;
  }

  /**
   * Prints the list of Todo based on given display options.
   * @param incompleteOnly If true, show only incomplete Todos, false otherwise.
   * @param categoryFilter Only display Todos with this category.
   * @param sortByDate If true, sorts Todos by due date (null due dates are after Todos with due dates).
   * @param sortByPriority If true, sorts Todos by priority.
   */
  public void display(Boolean incompleteOnly, String categoryFilter, Boolean sortByDate, Boolean sortByPriority){
    ArrayList<Todo> todos = new ArrayList(this.list.values());

    // Filter based on display options given
    // Combining filter show incomplete only and filter by category, so we only loop once.
    todos.removeIf(todo ->
        (incompleteOnly == Boolean.TRUE && todo.getCompleted() == Boolean.TRUE) ||
            (categoryFilter != null && !categoryFilter.equals(todo.getCategory()))
    );

    if (sortByDate == Boolean.TRUE) {
      todos.sort((todo1, todo2) -> {
        if(todo1.getDueDate()==null && todo2.getDueDate()==null) {
          return 0;
        }
        else if(todo1.getDueDate() == null){
          return 1;
        }
        else if(todo2.getDueDate() == null){
          return -1;
        }
        else{
          return todo1.getDueDate().compareTo(todo2.getDueDate()) ;
        }
      });
    }

    if (sortByPriority == Boolean.TRUE) {
      todos.sort((todo1, todo2) -> todo1.getPriority().compareTo(
          todo2.getPriority()));
    }

    if (todos.size() == 0) {
      System.out.println("No Todos to display with the given display options.");
    } else {
      for (Todo todo : todos) {
        System.out.println(todo.toString());
      }
    }
  }
}
