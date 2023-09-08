package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailGeneratorTest {

  private EmailGenerator testEmailGenerator;
  private EmailGenerator testEmailGenerator2;
  private EmailGenerator testEmailGenerator3;
  private EmailGenerator testEmailGenerator4;
  private EmailGenerator testEmailGenerator5;

  String filePath = new File("").getAbsolutePath();

  String emailTemplateFilePath = filePath + "/src/main/java/inputFiles/email-template.txt";
  String emailTemplateFilePath2 = filePath + "/src/main/java/inputFiles/email-template.txt2";
  String csvFilePath =  filePath + "/src/main/java/inputFiles/insurance-company-members.csv";
  String csvFilePath2 = filePath + "/src/main/java/inputFiles/insurance-company-members3.csv";
  String outputFilePath = filePath + "/src/main/java/outputFiles";
  String outputFilePath2 = filePath + "/src/main/java/outputFiles2";

  @BeforeEach
  void setUp() {

    testEmailGenerator = new EmailGenerator(csvFilePath, emailTemplateFilePath, outputFilePath);
    testEmailGenerator2 = new EmailGenerator(csvFilePath2, emailTemplateFilePath, outputFilePath);
    testEmailGenerator3 = new EmailGenerator(csvFilePath, emailTemplateFilePath2, outputFilePath);
    testEmailGenerator4 = new EmailGenerator(csvFilePath, emailTemplateFilePath, outputFilePath2);
  }

  @Test
  void testGetCsv() {
    assertEquals(csvFilePath, testEmailGenerator.getCsv());
  }

  @Test
  void testGetTemplate() {
    assertEquals(emailTemplateFilePath, testEmailGenerator.getTemplate());
  }

  @Test
  void testGetOutputDirPath() {
    assertEquals(outputFilePath, testEmailGenerator.getOutputDirPath());
  }

  @Test
  void testCreateFileName() {
    testEmailGenerator.parseCsv(csvFilePath);
    testEmailGenerator2.parseCsv(csvFilePath2);
    assertEquals("first_name_last_name_email_0.txt", testEmailGenerator.createFileName(0));
    assertEquals("email_0.txt", testEmailGenerator2.createFileName(0));
  }

  @Test
  void testGenerateDefaultFileName() {
    testEmailGenerator.parseCsv(csvFilePath);
    assertEquals("James, Jacob_Butt", testEmailGenerator.generateDefaultFileName(1));
  }

  @Test
  void testParseCsv() {
    testEmailGenerator.parseCsv(csvFilePath);
    assertEquals(501, testEmailGenerator.informationFromCsv.size());
  }

  @Test
  void testGenerate() throws IOException {
    String filepath = new File("").getAbsolutePath();
    String CSV = filepath + "/src/main/java/inputFiles/insurance-company-members.csv";
    String template = filepath + "/src/main/java/inputFiles/letter-template.txt";
    String output = filepath + "/src/test/java/testFiles";

    testEmailGenerator5 = new EmailGenerator(CSV,template,output);

    // This generates all the files
    testEmailGenerator5.generate();

    // Test to see if length of CSV matches expected
    assertEquals(501, testEmailGenerator5.informationFromCsv.size());

    // Generate Files
    testEmailGenerator5.writeFileContent(1, "zztestEmail.txt");
    testEmailGenerator5.writeFileContent(500, "zztestEmail2.txt");


    // Test to see if files are formatted correctly
    // This one should be generated as zztestEmail2 and compare it to the example file
    BufferedReader reader = new BufferedReader(new FileReader(filepath + "/src/test/java/testFiles/zztestEmail2.txt"));

    // This is reading the example file
    BufferedReader reader2 = new BufferedReader(new FileReader(
        filepath + "/src/test/java/testFiles/zzexampleFileEmail.txt"));
    String line;
    String line2;

    while (((line = reader.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
      // Expected = example file
      // Actual = output
      assertEquals(line2, line);
    }
  }

  @Test
  void testEquals() {
    testEmailGenerator2.getInformationFromCsv();
    assertFalse(testEmailGenerator.equals(testEmailGenerator2));
    assertFalse(testEmailGenerator.equals(testEmailGenerator3));
    assertFalse(testEmailGenerator.equals(testEmailGenerator4));
    assertTrue(testEmailGenerator.equals(testEmailGenerator));
    assertFalse(testEmailGenerator.equals(null));
  }

  @Test
  void testToString() {
    String expectedString = "EmailGenerator{" +
        "csv='" + csvFilePath + '\'' +
        ", template='" + emailTemplateFilePath + '\'' +
        ", outputDirPath='" + outputFilePath + '\'' +
        ", informationFromCsv=" + testEmailGenerator.getInformationFromCsv() +
        ", columnIndices=" + testEmailGenerator.getColumnIndices() +
        '}';
    assertEquals(expectedString, testEmailGenerator.toString());
  }
}