package problem1;

/**
 * Main class for running program and handling arguments from the user
 */
public class Main {
  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
    TodoApp app = new TodoApp();
    app.run(args);
  }
}
