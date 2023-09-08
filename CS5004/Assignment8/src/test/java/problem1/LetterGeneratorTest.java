package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LetterGeneratorTest {
  private LetterGenerator testLetterGenerator;
  String filepath = new File("").getAbsolutePath();
  String CSV = filepath + "/src/main/java/inputFiles/insurance-company-members.csv";
  String template = filepath + "/src/main/java/inputFiles/letter-template.txt";
  String output = filepath + "/src/test/java/testFiles";

  @BeforeEach
  void setUp() {
    testLetterGenerator = new LetterGenerator(CSV, template, output);
  }

  @Test
  void getCsv() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "/src/main/java/inputFiles/insurance-company-members.csv",testLetterGenerator.getCsv());

  }

  @Test
  void getTemplate() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "/src/main/java/inputFiles/letter-template.txt",testLetterGenerator.getTemplate());

  }

  @Test
  void getOutputDirPath() {
    String filepath = new File("").getAbsolutePath();
    assertEquals(filepath + "/src/test/java/testFiles",testLetterGenerator.getOutputDirPath());
  }

  @Test
  void createFileName() {
    testLetterGenerator.parseCsv(CSV);
    assertEquals("first_name_last_name_letter_0.txt",testLetterGenerator.createFileName(0));
    assertEquals("James, Jacob_Butt_letter_1.txt",testLetterGenerator.createFileName(1));
  }

  @Test
  void generate() throws IOException {
    String filepath = new File("").getAbsolutePath();
    // This generates all the files
    testLetterGenerator.generate();

    // Test to see if length of CSV matches expected
    assertEquals(501, testLetterGenerator.informationFromCsv.size());

    // Generate Files
    testLetterGenerator.writeFileContent(1, "zztestLetter.txt");
    testLetterGenerator.writeFileContent(500, "zztestLetter2.txt");

    // Test to see if files are formatted correctly
    // This one should be generated as zztestLetter2 and compare it to the example file
    BufferedReader reader = new BufferedReader(new FileReader(filepath + "/src/test/java/testFiles/zztestLetter2.txt"));

    // This is reading the example file
    BufferedReader reader2 = new BufferedReader(new FileReader(
        filepath + "/src/test/java/testFiles/zzexampleFileLetter.txt"));
    String line;
    String line2;

    while (((line = reader.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
      // Expected = example file
      // Actual = output
      assertEquals(line2, line);
    }
  }

  @Test
  void testCreateFileName() {
    String filepath = new File("").getAbsolutePath();
    String CSV = filepath + "/src/main/java/inputFiles/insurance-company-members3.csv";
    LetterGenerator testLetterGeneratorNoName = new LetterGenerator(CSV, template, output);
    testLetterGeneratorNoName.parseCsv(filepath);
    assertEquals("letter_" + 0 + ".txt", testLetterGeneratorNoName.createFileName(0));
  }

  @Test
  void testToString() {
    String expectedString = "LetterGenerator{" +
        "csv='" + CSV + '\'' +
        ", template='" + template + '\'' +
        ", outputDirPath='" + output + '\'' +
        ", informationFromCsv=" + testLetterGenerator.getInformationFromCsv() +
        ", columnIndices=" + testLetterGenerator.getColumnIndices() +
        '}';
    assertEquals(expectedString, testLetterGenerator.toString());
  }
}