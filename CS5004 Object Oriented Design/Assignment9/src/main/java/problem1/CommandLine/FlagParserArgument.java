package problem1.CommandLine;

import java.util.*;

/**
 * A flag ParserArgument object (argument that do not need values).
 */
public class FlagParserArgument extends ParserArgument<String> {

  /**
   * Constructor for the FlagParserArgument class
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param required Requires client to pass this argument.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that client cannot pass along with this argument.
   */
  public FlagParserArgument(String key, String description, Boolean required,
      ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs) {
    super(key, description, required, requiredArgs, excludedArgs);
  }

  /**
   * Constructor for the FlagParserArgument class
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param required Requires client to pass this argument.
   */
  public FlagParserArgument(String key, String description, Boolean required) {
    super(key, description, required);
  }

  /**
   * Constructor for the FlagParserArgument class
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   */
  public FlagParserArgument(String key, String description) {
    super(key, description);
  }

  /**
   * Prints text on how to use this argument.
   */
  public void printManual() {
    System.out.println("--" + this.key);
    System.out.println("\t\t" + this.description);
  }
}
