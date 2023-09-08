package problem1;

import java.io.File;

/**
 * Main class for running program and handling arguments from the user
 */
public class Main {

  /**
   * Main method for running program and handling arguments from the user
   * @param args - arguments provided by the user
   */
  public static void main(String[] args) {
    try {
      String filePath = new File("").getAbsolutePath();
      String emailTemplateFilePath = filePath +  "/src/main/java/inputFiles/email-template.txt";
      String csvFilePath = filePath + "/src/main/java/inputFiles/insurance-company-members.csv";
      String outputFilePath = filePath + "/src/main/java/outputFiles";
      String letterTemplateFilePath = filePath + "/src/main/java/inputFiles/letter-template.txt";

      String[] arguments = {"--email", "--email-template", emailTemplateFilePath, "--letter", "--letter-template", letterTemplateFilePath,"--csv-file", csvFilePath, "--output-dir", outputFilePath};

      CommandLineParser commandLine = new CommandLineParser(arguments);



    } catch (InvalidArgumentsException e) {
      System.out.println("ERROR: " + e.getMessage());
    }
  }
}
