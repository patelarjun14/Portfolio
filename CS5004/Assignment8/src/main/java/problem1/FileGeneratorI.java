package problem1;

/**
 * Interface for the file generator class
 */
public interface FileGeneratorI {

  /**
   * Method to create file names
   * @param index - index of the name in the row to be returned
   * @return - the filename
   */
  String createFileName(Integer index);

  /**
   * Method that is used to call the other helper methods to read, input, and generate the desired files
   */
  void parseCsv(String csv);

  /**
   * Method to read data from template, input the correct data,and then generate the file
   * @param rowIndex - rowIndex to read, input,and write data
   * @param fileName - file name of the file to be generated
   */
  void writeFileContent(Integer rowIndex, String fileName);

  /**
   * Method that is used to call the other helper methods to read, input, and generate the desired files
   */
  void generate();
}
