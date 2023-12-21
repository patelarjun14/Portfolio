package problem1;

/**
 * Email generator is a class that is used to generate emails to users
 */
public class EmailGenerator extends FileGenerator {

  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */

  public EmailGenerator(String csv, String template, String outputDirPath) {
    super(csv, template, outputDirPath);
  }

  /**
   * Method to create file names
   * @param index - index of the name in the row to be returned
   * @return - the filename
   */
  @Override
  public String createFileName(Integer index){
    // By default, use first name and last name keys
    String defaultName = this.generateDefaultFileName(index);

    // If generating default file name produce empty file name
    if (defaultName.equals("")) {
      return "email_" + index + ".txt";
    } else {
      return defaultName + "_email_" + index + ".txt";
    }
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "EmailGenerator{" +
        "csv='" + this.csv + '\'' +
        ", template='" + this.template + '\'' +
        ", outputDirPath='" + this.outputDirPath + '\'' +
        ", informationFromCsv=" + this.informationFromCsv +
        ", columnIndices=" + this.columnIndices +
        '}';
  }
}
