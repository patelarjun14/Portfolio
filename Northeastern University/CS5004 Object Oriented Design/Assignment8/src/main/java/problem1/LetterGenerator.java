package problem1;

public class LetterGenerator extends FileGenerator{
  /**
   * @param csv       CSV file to derive information from to fill letter
   * @param template  Template file to use to generate letter
   * @param outputDirPath Output directory to save newly generated letter to.
   */
  public LetterGenerator(String csv, String template, String outputDirPath) {
    super(csv, template, outputDirPath);
  }

  /**
   * Helper method to create the file name.
   * @param index - index of the name in the row to be returned
   * @return the file name.
   */
  @Override
  public String createFileName(Integer index){
    // By default, use first name and last name keys
    String defaultName = this.generateDefaultFileName(index);

    // If generating default file name produce empty file name
    if (defaultName.equals("")) {
      return "letter_" + index + ".txt";
    } else {
      return defaultName + "_letter_" + index + ".txt";
    }
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "LetterGenerator{" +
        "csv='" + this.csv + '\'' +
        ", template='" + this.template + '\'' +
        ", outputDirPath='" + this.outputDirPath + '\'' +
        ", informationFromCsv=" + this.informationFromCsv +
        ", columnIndices=" + this.columnIndices +
        '}';
  }
}
