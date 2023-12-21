package problem1.CommandLine;

import java.util.*;

/**
 * An object to define an argument for CommandLineParser
 */
public abstract class ParserArgument<T> {
  public String key;
  public String description;
  public T value = null;
  public Boolean required;
  public Boolean allowMultiple;
  ArrayList<String> requiredArgs;
  ArrayList<String> excludedArgs;

  /**
   * Constructor for the ParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param required Requires client to pass this argument.
   * @param allowMultiple If true, this argument is allowed to be called multiple times in one call.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that cannot be given along with this argument.
   */
  public ParserArgument(String key, String description, Boolean required, Boolean allowMultiple, ArrayList<String> requiredArgs, ArrayList<String> excludedArgs) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = allowMultiple;
    this.requiredArgs = requiredArgs;
    this.excludedArgs = excludedArgs;
  }

  /**
   * Constructor for the ParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param required Requires client to pass this argument.
   * @param requiredArgs List of argument keys that also needs to be given along with this argument.
   * @param excludedArgs List of argument keys that cannot be given along with this argument.
   */
  public ParserArgument(String key, String description, Boolean required, ArrayList<String> requiredArgs, ArrayList<String> excludedArgs) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = requiredArgs;
    this.excludedArgs = excludedArgs;
  }

  /**
   * Constructor for the ParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   * @param required Requires client to pass this argument.
   */
  public ParserArgument(String key, String description, Boolean required) {
    this.key = key;
    this.description = description;
    this.required = required;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = new ArrayList();
    this.excludedArgs = new ArrayList();
  }

  /**
   * Constructor for the ParserArgument class.
   * @param key Unique identifier for this argument.
   *            Also used as the key the client will use in CommandLineParser for this argument.
   * @param description Description of the argument.
   */
  public ParserArgument(String key, String description) {
    this.key = key;
    this.description = description;
    this.required = Boolean.FALSE;
    this.allowMultiple = Boolean.FALSE;
    this.requiredArgs = new ArrayList();
    this.excludedArgs = new ArrayList();
  }

  /**
   * Returns the ParserArgument's key.
   * @return the ParserArgument's key.
   */
  public String getKey() {
    return this.key;
  }

  /**
   * Sets the ParserArgument's key.
   * @param key the new ParserArgument key.
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Returns the ParserArgument's description.
   * @return the ParserArgument's description.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Sets the ParserArgument's description.
   * @param description the new ParserArgument description.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Returns the current value of the ParserArgument.
   * @return
   */
  public T getValue() {
    return this.value;
  }

  /**
   * Sets the value of the ParserArgument.
   * @param value the new value of this ParserArgument.
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Returns if this argument is required.
   * @return True if required, false otherwise.
   */
  public Boolean getRequired() {
    return this.required;
  }

  /**
   * Sets the requirement of this ParserArgument.
   * @param required True if required, false otherwise.
   */
  public void setRequired(Boolean required) {
    this.required = required;
  }

  /**
   * Returns the list of argument keys that also needs to be given along with this argument.
   * @return List of argument keys that also needs to be given along with this argument.
   */
  public ArrayList<String> getRequiredArgs() {
    return this.requiredArgs;
  }

  /**
   * Sets the list of argument keys that also needs to be given along with this argument.
   * @param requiredArgs New list of argument keys that also needs to be given along with this argument.
   */
  public void setRequiredArgs(ArrayList<String> requiredArgs) {
    this.requiredArgs = requiredArgs;
  }

  /**
   * Returns the list of argument keys that cannot be given along with this argument.
   * @return List of argument keys that cannot be given along with this argument.
   */
  public ArrayList<String> getExcludedArgs() {
    return this.excludedArgs;
  }

  /**
   * Sets the list of argument keys that cannot be given along with this argument.
   * @param excludedArgs New list of argument keys that cannot be given along with this argument.
   */
  public void setExcludedArgs(ArrayList<String> excludedArgs) {
    this.excludedArgs = excludedArgs;
  }

  /**
   * Checks if argument is required and if client passes the argument.
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException
   */
  public void checkRequired(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    if (this.required && !args.containsKey(this.key)) {
      throw new InvalidArgumentsException("'" + this.key + "' is required.");
    }
  }

  /**
   * Checks if other required arguments were passed along with this argument.
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException
   */
  public void checkRequiredArguments(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    for (String requiredArg: this.requiredArgs){
      if (args.containsKey(this.key) && !args.containsKey(requiredArg)){
        throw new InvalidArgumentsException("'" + this.key + "' requires '" + requiredArg+ "'.");
      }
    }
  }

  /**
   * Checks if other excluded arguments were not passed along with this argument.
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException
   */
  public void checkExcludedArguments(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException {
    for (String excludedArg: this.excludedArgs){
      if (args.containsKey(this.key) && args.containsKey(excludedArg)){
        throw new InvalidArgumentsException("'" + this.key + "' cannot be used with " + excludedArg + ".");
      }
    }
  }

  /**
   * Performs numerous checks to check if ParserArgument's current value throws any errors.
   * @param args HashMap representation of client's arguments passed through CommandLineParser.
   * @throws InvalidArgumentsException
   */
  public void validate(HashMap<String, ArrayList<String>> args) throws InvalidArgumentsException{
    this.checkRequired(args);
    this.checkRequiredArguments(args);
    this.checkExcludedArguments(args);
  }

  /**
   * Prints text on how to use this argument.
   */
  public abstract void printManual();
}
