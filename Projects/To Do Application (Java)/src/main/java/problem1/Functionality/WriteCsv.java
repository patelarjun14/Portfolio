package problem1.Functionality;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import problem1.Csv;
import problem1.Todo;
import problem1.TodoList;

/**
 * Class that writes to a CSV.
 */
public class WriteCsv {
  public String pathToFile;
  public Csv csv;

  /**
   * Constructor for the WriteCsv class.
   * @param pathToFile path to CSV file.
   * @param csv Csv object to write to.
   */
  public WriteCsv(String pathToFile, Csv csv){
    this.pathToFile = pathToFile;
    this.csv = csv;
  }

  /**
   * Constructor for the WriteCsv class.
   * @param pathToFile path to CSV file.
   */
  public WriteCsv(String pathToFile){
    this.pathToFile = pathToFile;
    this.csv = new Csv(pathToFile);
  }

  /**
   * Writes current state of a TodoList to the CSV file.
   * @param list TodoList to write into the CSV file.
   */
  public void write(TodoList list) {
    ArrayList<ArrayList<String>> data = new ArrayList();
    if (csv.getData().size() > 0){
      data.add(csv.getData().get(0));

      for (Todo todo: list.getList()) {
        ArrayList<String> row = new ArrayList();

        // Initialize row with null values to prevent index out of bounds error
        for (int i = 0; i < data.get(0).size(); i++){
          row.add(null);
        }

        Integer idIndex = csv.getColumnIndex("id");
        Integer textIndex = csv.getColumnIndex("text");
        Integer completedIndex = csv.getColumnIndex("completed");
        Integer dueIndex = csv.getColumnIndex("due");
        Integer priorityIndex = csv.getColumnIndex("priority");
        Integer categoryIndex = csv.getColumnIndex("category");

        if (idIndex != null){
          row.set(idIndex, todo.getId().toString());
        }

        if (textIndex != null){
          row.set(textIndex, todo.getText());
        }

        if (completedIndex != null) {
          row.set(completedIndex, todo.getCompleted().toString());
        }

        if (dueIndex != null) {
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
          if (todo.getDueDate() != null) {
            row.set(dueIndex, todo.getDueDate().format(formatter));
          }
        }

        if (priorityIndex != null) {
          row.set(priorityIndex, todo.getPriority().toString());
        }

        if (categoryIndex != null) {
          row.set(categoryIndex, todo.getCategory());
        }

        data.add(row);
      }

      csv.setData(data);
      csv.writeData();
    }
  }
}