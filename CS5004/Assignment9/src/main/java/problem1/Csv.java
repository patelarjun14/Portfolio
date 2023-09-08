package problem1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Csv object to read, parse, update, and write a CSV file.
 */
public class Csv {
  public String DEFAULT_EMPTY_CELL = "?";
  public String pathToFile;
  public ArrayList<ArrayList<String>> data = new ArrayList<>();
  public HashMap<String, Integer> columnIndices = new HashMap<>();

  /**
   * Constructor for the Csv class.
   * @param pathToFile path to CSV file.
   */
  public Csv(String pathToFile){
    this.pathToFile = pathToFile;

    this.parse();
  }

  /**
   * Reads a CSV file and parses its contents to an ArrayList<ArrayList<String>> for easy access.
   */
  void parse() {
    try{
      BufferedReader reader = new BufferedReader(new FileReader(this.pathToFile));
      String line;
      while ((line = reader.readLine()) != null) {
        ArrayList<String> csvRow = new ArrayList<>(Arrays.asList(line.split("\"*,*\"")));
        // remove extra column created due to first opening .
        csvRow.remove(0);
        this.data.add(csvRow);
      }
      reader.close();
      this.createColumnIndices();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Helper method to create column indices with key values that match the csv headers.
   */
  private void createColumnIndices() {
    if (this.data.size() > 0 ) {
      ArrayList<String> headerRow = this.data.get(0);
      for (int i = 0; i < headerRow.size(); i++) {
        String key = headerRow.get(i);
        if (!key.equals("")) {
          Integer value = i;
          this.columnIndices.put(key, value);
        }
      }
    }
  }

  /**
   * Returns data from CSV.
   * @return Current data in the CSV.
   */
  public ArrayList<ArrayList<String>> getData() {
    return this.data;
  }

  /**
   * Sets current data for CSV.
   * @param data New data for the CSV.
   */
  public void setData(ArrayList<ArrayList<String>> data) {
    this.data = data;
  }

  /**
   * Write current data state into CSV file.
   */
  public void writeData() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToFile));
      String csvString = this.getDataAsString();
      for (String line: csvString.split("\n")){
        writer.write(line);
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Adds a row to the CSV data.
   * @param data New data row to be added.
   */
  public void addRow(HashMap<String, String> data){
    ArrayList<String> newRow = new ArrayList<>();

    // Initialize all cells of the new row to be empty
    for (int i = 0; i < this.data.get(0).size(); i++) {
      newRow.add(this.DEFAULT_EMPTY_CELL);
    }

    for (String key: data.keySet()) {
      Integer index = this.columnIndices.get(key);
      if (index != null) {
        newRow.add(index, data.get(key));
      }
    }

    this.data.add(newRow);
  }

  /**
   * Finds a cell in the CSV using a column key of the unique identifier and the unique identifier.
   * A unique identifier differentiates each row from each other. For example, an id.
   * @param uniqueIdentifierKey Column key the unique identifier can be found.
   * @param uniqueIdentifier The unique identifier to look for.
   * @return The row index of the data we are searching for.
   */
  public Integer getRow(String uniqueIdentifierKey, String uniqueIdentifier) {
    Integer index = this.columnIndices.get(uniqueIdentifierKey);

    if (index != null){
      for (int i = 0; i < this.data.size(); i++){
        if (Objects.equals(this.data.get(i).get(index), uniqueIdentifier)){
          return i;
        }
      }
    }

    return -1;
  }

  /**
   * Returns the index of the column using the related column key.
   * @param key Column title or column key.
   * @return Column index of the given key.
   */
  public Integer getColumnIndex(String key) {
    return this.columnIndices.get(key);
  }

  /**
   * Returns the list of column keys in the CSV.
   * @return List of column keys in the CSV.
   */
  public ArrayList<String> getColumns() {
    return new ArrayList(this.columnIndices.keySet());
  }

  /**
   * Finds a cell in the CSV using its row and column key and returns its value.
   * @param row Index of the cell's row.
   * @param columnKey Key of the cell's column.
   * @return Current value of the cell.
   */
  public String getValue(Integer row, String columnKey){
    Integer index = this.columnIndices.get(columnKey);

    if (index != null){
      String value = this.data.get(row).get(index);

      if (!value.equals(this.DEFAULT_EMPTY_CELL) && !value.equals("")) {
        return value;
      }
    }

    return null;
  }

  /**
   * Finds a cell in the CSV using its row and column key, then sets its value.
   * @param row Index of the cell's row.
   * @param columnKey Key of the cell's column.
   * @param newValue New Value to set.
   */
  public void setValue(Integer row, String columnKey, String newValue) {
    Integer index = this.columnIndices.get(columnKey);

    if (index != null){
      this.data.get(row).set(index, newValue);
    }
  }

  /**
   * Returns a String representation of the CSV data.
   * @return String representation of the CSV data.
   */
  public String getDataAsString(){
    String content = "";
    for (ArrayList<String> row: this.data){
      for (int i = 0; i < row.size(); i++){
        if (row.get(i) != null) {
          content = content.concat("\"" + row.get(i) + "\"");
        } else {
          content = content.concat("\"" + this.DEFAULT_EMPTY_CELL + "\"");
        }

        if (i != row.size() - 1){
          content = content.concat(",");
        }
      }
      content = content.concat("\n");
    }
    return content;
  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @param o - The object we are comparing to.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Csv csv = (Csv) o;
    return pathToFile.equals(csv.pathToFile) && Objects.equals(data, csv.data)
        && Objects.equals(columnIndices, csv.columnIndices);
  }

  /**
   * Method to determine if the hashcode of the object is a match
   * @return - a hashcode value for the object returned as an integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.pathToFile);
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "Csv{" +
        "pathToFile='" + pathToFile + '\'' +
        "content='" + this.getDataAsString() + "'" +
        '}';
  }
}
