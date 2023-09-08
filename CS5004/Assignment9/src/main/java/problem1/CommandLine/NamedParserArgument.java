package problem1.CommandLine;

import java.util.*;

/**
 * Creates a ParserArgument object for a named (key,value) command line parser argument.
 */
public class NamedParserArgument extends ParserArgument<ArrayList<String>> {
  public HashSet<String> validValues = null;
  public String valueDescription;

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param allowMultiple If true, this argument is allowed to be called multiple times in one call.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that cannot be given along with this argument.
   * @param validValues Set of valid values this argument can be set to.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple, ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs, HashSet<String> validValues) {
    super(key, description, required, allowMultiple, requiredArgs, excludedArgs);
    this.validValues = validValues;
    this.valueDescription = valueDescription;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param allowMultiple If true, this argument is allowed to be called multiple times in one call.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that cannot be given along with this argument.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple, ArrayList<String> requiredArgs, ArrayList<String> excludedArgs) {
    super(key, description, required, allowMultiple, requiredArgs, excludedArgs);
    this.valueDescription = valueDescription;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that cannot be given along with this argument.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,ArrayList<String> requiredArgs,
      ArrayList<String> excludedArgs) {
    super(key, description, required, Boolean.FALSE, requiredArgs, excludedArgs);
    this.valueDescription = valueDescription;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param allowMultiple If true, this argument is allowed to be called multiple times in one call.
   * @param validValues Set of valid values this argument can be set to.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple, HashSet<String> validValues) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.allowMultiple = allowMultiple;
    this.validValues = validValues;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param allowMultiple If true, this argument is allowed to be called multiple times in one call.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required,
      Boolean allowMultiple) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.allowMultiple = allowMultiple;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   * @param validValues Set of valid values this argument can be set to.
   */
  public NamedParserArgument(String key, String description, String valueDescription, Boolean required, HashSet<String> validValues) {
    super(key, description, required);
    this.valueDescription = valueDescription;
    this.validValues = validValues;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   * @param required Requires client to pass this argument.
   */
  public NamedParserArgument(String key, String description,String valueDescription, Boolean required) {
    super(key, description, required);
    this.valueDescription = valueDescription;
  }

  /**
   * Constructor for the NamedParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param valueDescription Description of the value this argument takes.
   */
  public NamedParserArgument(String key, String description, String valueDescription) {
    super(key, description);
    this.valueDescription = valueDescription;
  }

  /**
   * Gets the value.
   * @return current value.
   */
  public ArrayList<String> getValue() {
    return this.value;
  }

  /**
   * Sets the value.
   * @param value new value to be set.
   */
  public void setValue(ArrayList<String> value) {
    this.value = value;
  }

  /**
   * Checks if client actually passed a value through CommandLineParser.
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException - Exception if an invalid argument is entered
   */
  public void checkIfValueGiven(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    // User can pass the argument but not actually provide value.
    // We want to catch this error and let the user know.
    if (args.containsKey(this.key) && this.value == null){
      throw new InvalidArgumentsException("'" + this.key + "' expects to be given a value.");
    }
  }

  /**
   * Checks if the given value is any of the valid values.
   * @throws InvalidArgumentsException - Exception if an invalid argument is entered
   */
  public void checkValidValues() throws InvalidArgumentsException{
    if (this.validValues != null && this.value != null){
      for (String value: this.value) {
        if (!this.validValues.contains(value)){
          throw new InvalidArgumentsException("'" + this.key + "' values can only be " + this.validValues);
        }
      }
    }
  }

  /**
   * Method to help validate data
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException - Exception for invalid arguments
   */
  @Override
  public void validate(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    super.validate(args);
    // Run more checks
    this.checkValidValues();
    this.checkIfValueGiven(args);
  }

  /**
   * Prints text on how to use this argument.
   */
  public void printManual() {
    System.out.println("--" + this.key + " <" + this.valueDescription + ">");
    System.out.println("\t\t" + this.description);
  }
}
