package problem1.CommandLine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {
  private CommandLineParser testCommandLineParser;

  @BeforeEach
  void setUp() {
    ArrayList<ParserArgument> arguments = new ArrayList();
    String argumentPrefix = "--";

    testCommandLineParser = new CommandLineParser(arguments , argumentPrefix);
  }

  @Test
  void getArguments() {
    assertEquals(0, testCommandLineParser.getArguments().size());
  }

  @Test
  void getArgumentPrefix() {
    assertEquals("--", testCommandLineParser.getArgumentPrefix());
  }

  @Test
  void getProcessedArgs() {
    assertEquals(0, testCommandLineParser.getProcessedArgs().size());
  }

  @Test
  void getArgumentsMap() {
    assertEquals(0, testCommandLineParser.getArgumentsMap().size());

  }

}