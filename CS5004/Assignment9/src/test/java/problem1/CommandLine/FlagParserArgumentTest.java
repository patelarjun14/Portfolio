package problem1.CommandLine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlagParserArgumentTest {
  FlagParserArgument testFlagArgument;

  @Test
  void testConstructor() {
    testFlagArgument = new FlagParserArgument("test", "test argument");
    assertEquals(testFlagArgument.key, "test");
  }

  @Test
  void getValue() {
    testFlagArgument = new FlagParserArgument("test", "test argument");
    assertEquals(testFlagArgument.getValue(), null);
  }

  @Test
  void printManual(){
    testFlagArgument = new FlagParserArgument("test", "test argument");
    assertDoesNotThrow(() -> {
      testFlagArgument.printManual();
    });
  }
}