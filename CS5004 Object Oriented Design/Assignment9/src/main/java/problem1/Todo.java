package problem1;

import java.time.LocalDate;

/**
 * Class that creates a Todo object
 */
public class Todo {
  public Integer DEFAULT_PRIORITY = 3;

  private final Integer id;
  private final String text;
  private Boolean completed;
  private final LocalDate dueDate;
  private final Integer priority;
  private final String category;

  /**
   * Constructor for the Todo class.
   * @param id Unique identifier used to differentiate from other Todo objects.
   * @param text Text description of the Todo.
   * @param completed If true, Todo has been completed, false otherwise.
   * @param dueDate Date of when the Todo should be completed by.
   * @param priority Priority level of the Todo.
   * @param category Category of the Todo.
   */
  public Todo(Integer id, String text, Boolean completed, LocalDate dueDate,
      Integer priority, String category) {
    this.id = id;
    this.text = text;
    this.completed = completed;
    this.dueDate = dueDate;
    if (priority != null) {
      this.priority = priority;
    } else {
      this.priority = this.DEFAULT_PRIORITY;
    }
    this.category = category;
  }

  /**
   * Sets the completion status of this Todo.
   * @param completed true if Todo is completed, false otherwise.
   */
  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  /**
   * Returns Todo id.
   * @return Todo id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Returns Todo text.
   * @return Todo text.
   */
  public String getText() {
    return text;
  }

  /**
   * Returns Todo completion status.
   * @return True if Todo is completed, false otherwise.
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Returns Todos due date.
   * @return Todos due date.
   */
  public LocalDate getDueDate() {
    return dueDate;
  }

  /**
   * Returns Todos priority.
   * @return Todos priority.
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Returns Todos category.
   * @return Todos category.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", text='" + text + '\'' +
        ", completed=" + completed +
        ", dueDate=" + dueDate +
        ", priority=" + priority +
        ", category='" + category + '\'' +
        '}';
  }
}