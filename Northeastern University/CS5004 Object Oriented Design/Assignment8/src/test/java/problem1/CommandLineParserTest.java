package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  String filePath = new File("").getAbsolutePath();
  String emailTemplateFilePath = filePath + "/src/main/java/inputFiles/email-template.txt";
  String letterTemplateFilePath = filePath + "/src/main/java/inputFiles/letter-template.txt";
  String outputDirectoryFilePath = filePath + "/src/main/java/outputFiles";
  String csvFilePath = filePath + "/src/main/java/inputFiles/insurance-company-members.csv";
  String[] expectedRequiredOptions = {"--output-dir", "--csv-file"};

  String [] validArguments = {"--email", "--email-template", emailTemplateFilePath, "--letter", "--letter-template", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
  CommandLineParser testCommandLineParser;
  HashMap<String, String> testCheckRequireOptions = new HashMap<String, String >();

  @BeforeEach
  void setUp() throws InvalidArgumentsException {
    testCommandLineParser = new CommandLineParser(validArguments);
  }

  @Test
  void getRequiredOptions() {
    assertArrayEquals(expectedRequiredOptions, testCommandLineParser.getRequiredOptions());
  }

  @Test
  void getEmailTemplate() {
    assertEquals(emailTemplateFilePath, testCommandLineParser.getEmailTemplate());
  }

  @Test
  void getLetterTemplate() {
    assertEquals(letterTemplateFilePath, testCommandLineParser.getLetterTemplate());
  }

  @Test
  void getCsv() {
    assertEquals(csvFilePath, testCommandLineParser.getCsv());
  }

  @Test
  void getOutputDirPath() {
    assertEquals(outputDirectoryFilePath, testCommandLineParser.getOutputDirPath());
  }

  @Test
  void checkRequiredOptions() {
    testCheckRequireOptions.put("--output-dir", outputDirectoryFilePath);

    assertThrows(InvalidArgumentsException.class, () -> {
      testCommandLineParser.checkRequiredOptions(testCheckRequireOptions);
    }, "--csv-file option is required.");
  }

  @Test
  void testEquals() throws InvalidArgumentsException {
    CommandLineParser testSameCommandLineParser = new CommandLineParser(validArguments);
    String [] validEmailArguments = {"--email", "--email-template", emailTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    CommandLineParser testCommandLineParserEmailOnly = new CommandLineParser(validEmailArguments);
    String [] validLetterArguments = {"--letter", "--letter-template", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    CommandLineParser testCommandLineParserLetterOnly = new CommandLineParser(validLetterArguments);
    assertTrue(testCommandLineParser.equals(testCommandLineParser));
    assertTrue(testCommandLineParser.equals(testSameCommandLineParser));
    assertFalse(testCommandLineParser.equals(testCommandLineParserEmailOnly));
    assertFalse(testCommandLineParser.equals(testCommandLineParserLetterOnly));
    assertFalse(testCommandLineParser.equals(testCheckRequireOptions));
    assertFalse(testCommandLineParser.equals(null));
  }

  @Test
  void testHashCode() throws InvalidArgumentsException {
    CommandLineParser testSameCommandLineParser = new CommandLineParser(validArguments);
    assertTrue(testCommandLineParser.equals(testSameCommandLineParser) && testSameCommandLineParser.equals(testCommandLineParser));
    assertTrue(testCommandLineParser.hashCode() == testSameCommandLineParser.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandLineParser{" +
        "requiredOptions=" + Arrays.toString(expectedRequiredOptions) +
        ", emailTemplate='" + emailTemplateFilePath + '\'' +
        ", letterTemplate='" + letterTemplateFilePath + '\'' +
        ", csv='" + csvFilePath + '\'' +
        ", outputDirPath='" + outputDirectoryFilePath + '\'' +
        '}';
    assertEquals(expectedString, testCommandLineParser.toString());
  }

  @Test
  void testInvalidArguments() throws InvalidArgumentsException {
    String [] invalidArgumentsMissingEmailTemplate = {"--email", emailTemplateFilePath, "--letter", "--letter-template", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    assertThrows(InvalidArgumentsException.class, () -> {
      CommandLineParser testInvalidCommandLineMissingEmailOption = new CommandLineParser(invalidArgumentsMissingEmailTemplate);
    }, "Email option chosen but no email template given.");

    String [] invalidArgumentsMissingEmailPath = {"--email", "--email-template", "--letter", "--letter-template", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    assertThrows(InvalidArgumentsException.class, () -> {
      CommandLineParser testInvalidCommandLineMissingEmailOption = new CommandLineParser(invalidArgumentsMissingEmailPath);
    }, "Email option chosen but no email template given.");

    String [] invalidArgumentsMissingLetterTemplate = {"--email", "--email-template", emailTemplateFilePath, "--letter", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    assertThrows(InvalidArgumentsException.class, () -> {
      CommandLineParser testInvalidCommandLineMissingEmailOption = new CommandLineParser(invalidArgumentsMissingLetterTemplate);
    }, "Email option chosen but no email template given.");

    String [] invalidArgumentsMissingLetterPath = {"--email", "--email-template", emailTemplateFilePath, "--letter", "--letter-template", "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    assertThrows(InvalidArgumentsException.class, () -> {
      CommandLineParser testInvalidCommandLineMissingEmailOption = new CommandLineParser(invalidArgumentsMissingLetterPath);
    }, "Email option chosen but no email template given.");

    String [] invalidArgumentsMissingLetterAndEmailOptions = {"--email-template", emailTemplateFilePath, "--letter-template", letterTemplateFilePath, "--output-dir", outputDirectoryFilePath, "--csv-file", csvFilePath};
    assertThrows(InvalidArgumentsException.class, () -> {
      CommandLineParser testInvalidCommandLineMissingEmailOption = new CommandLineParser(invalidArgumentsMissingLetterAndEmailOptions);
    }, "Neither email option or letter option were chosen.");
  }
}