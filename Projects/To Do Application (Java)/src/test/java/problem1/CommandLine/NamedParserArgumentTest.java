package problem1.CommandLine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NamedParserArgumentTest {
  NamedParserArgument testNamedArgument;

  @BeforeEach
  void setUp() {
    testNamedArgument = new NamedParserArgument("test", "testing argument", "test value");
  }

  @Test
  void testConstructors() {
    testNamedArgument = new NamedParserArgument("test", "testing argument", "test value", Boolean.TRUE, new ArrayList<String>(), new ArrayList<String>());
    assertEquals(testNamedArgument.valueDescription, "test value");

    testNamedArgument = new NamedParserArgument("test", "testing argument", "test value", Boolean.TRUE, Boolean.TRUE, new HashSet<String>());
    assertEquals(testNamedArgument.allowMultiple, Boolean.TRUE);

    HashSet<String> testValidValues = new HashSet<String>();
    testValidValues.add("2");
    testNamedArgument = new NamedParserArgument("test", "testing argument", "test value", Boolean.TRUE, testValidValues);
    assertEquals(testNamedArgument.validValues, testValidValues);
  }

  @Test
  void getValue() {
    assertEquals(testNamedArgument.getValue(), null);
    ArrayList<String> testValues = new ArrayList();
    testValues.add("2");
    testNamedArgument.setValue(testValues);
    assertEquals(testNamedArgument.getValue(), testValues);
  }

  @Test
  void checkIfValueGiven() {
    HashMap<String, ArrayList<String>> testArgs = new HashMap();
    ArrayList<String> emptyValues = new ArrayList();
    testArgs.put("test", emptyValues);

    assertThrows(InvalidArgumentsException.class, () -> {
      testNamedArgument.checkIfValueGiven(testArgs);
    }, "Invalid argument: 'test' expects to be given a value");
  }

  @Test
  void checkValidValues() throws InvalidArgumentsException{
    assertDoesNotThrow(() -> {
      testNamedArgument.checkValidValues();
    });

    ArrayList<String> testValues = new ArrayList();
    testValues.add("2");
    testNamedArgument.setValue(testValues);

    assertDoesNotThrow(() -> {
      testNamedArgument.checkValidValues();
    });

    HashSet<String> testValidValues = new HashSet();
    testValidValues.add("1");
    testNamedArgument.validValues = testValidValues;

    assertThrows(InvalidArgumentsException.class, () -> {
      testNamedArgument.checkValidValues();
    }, "Invalid argument: 'test' values can only be {1}");

    testNamedArgument.setValue(null);
    assertDoesNotThrow(() -> {
      testNamedArgument.checkValidValues();
    });
  }

  @Test
  void printManual(){
    assertDoesNotThrow(() -> {
      testNamedArgument.printManual();
    });
  }

  @Test
  void getKey() {
    assertEquals(testNamedArgument.getKey(), "test");
  }

  @Test
  void setKey() {
    testNamedArgument.setKey("other test");
    assertEquals(testNamedArgument.getKey(), "other test");
  }

  @Test
  void getDescription() {
    assertEquals(testNamedArgument.getDescription(), "testing argument");
  }

  @Test
  void setDescription() {
    testNamedArgument.setDescription("new description");
    assertEquals(testNamedArgument.getDescription(), "new description");
  }

  @Test
  void getRequired() {
    assertEquals(testNamedArgument.getRequired(), Boolean.FALSE);
  }

  @Test
  void setRequired() {
    testNamedArgument.setRequired(Boolean.TRUE);
    assertEquals(testNamedArgument.getRequired(), Boolean.TRUE);
  }

  @Test
  void getRequiredArgs() {
    assertEquals(testNamedArgument.getRequiredArgs(), new ArrayList<>());
  }

  @Test
  void setRequiredArgs() {
    ArrayList<String> testRequiredArgs = new ArrayList();
    testRequiredArgs.add("nothing");
    testNamedArgument.setRequiredArgs(testRequiredArgs);
    assertEquals(testNamedArgument.getRequiredArgs(), testRequiredArgs);
  }

  @Test
  void getExcludedArgs() {
    assertEquals(testNamedArgument.getExcludedArgs(), new ArrayList<>());
  }

  @Test
  void setExcludedArgs() {
    ArrayList<String> testRequiredArgs = new ArrayList();
    testRequiredArgs.add("nothing");
    testNamedArgument.setExcludedArgs(testRequiredArgs);
    assertEquals(testNamedArgument.getExcludedArgs(), testRequiredArgs);
  }

  @Test
  void checkRequired() {
    HashMap<String, ArrayList<String>> testArgs = new HashMap<>();
    assertDoesNotThrow(() -> {
      testNamedArgument.checkRequired(testArgs);
    });

    testNamedArgument.setRequired(Boolean.TRUE);
    assertThrows(InvalidArgumentsException.class, () -> {
      testNamedArgument.checkRequired(testArgs);
    }, "Invalid argument: 'test' is required.");
  }

  @Test
  void checkRequiredArguments() {
    HashMap<String, ArrayList<String>> testArgs = new HashMap<>();
    assertDoesNotThrow(() -> {
      testNamedArgument.checkRequiredArguments(testArgs);
    });

    testArgs.put("test", null);
    ArrayList<String> testRequiredArgs = new ArrayList<>();
    testRequiredArgs.add("other-test");
    testNamedArgument.setRequiredArgs(testRequiredArgs);
    assertThrows(InvalidArgumentsException.class, () -> {
      testNamedArgument.checkRequiredArguments(testArgs);
    }, "Invalid argument: 'test' required 'other-test'.");
  }

  @Test
  void checkExcludedArguments() {
    HashMap<String, ArrayList<String>> testArgs = new HashMap<>();
    assertDoesNotThrow(() -> {
      testNamedArgument.checkExcludedArguments(testArgs);
    });

    ArrayList<String> testRequiredArgs = new ArrayList<>();
    testRequiredArgs.add("other-test");
    testNamedArgument.setExcludedArgs(testRequiredArgs);
    testArgs.put("test", null);
    testArgs.put("other-test", null);
    assertThrows(InvalidArgumentsException.class, () -> {
      testNamedArgument.checkExcludedArguments(testArgs);
    }, "Invalid argument: 'test' required 'other-test'.");
  }
}