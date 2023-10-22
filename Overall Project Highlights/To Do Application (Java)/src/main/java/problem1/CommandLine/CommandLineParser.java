package problem1.CommandLine;

import java.util.*;

/**
 * Processes and validates command line arguments.
 */
public class CommandLineParser {
  public ArrayList<ParserArgument> arguments;
  public String argumentPrefix = "--";

  public HashMap<String, ArrayList<String>> processedArgs = new HashMap();
  public HashMap<String, ParserArgument> argumentsMap = new HashMap();

  /**
   * Constructor for the CommandLineParser class.
   * @param arguments - The arguments provided by the user.
   * @param argumentPrefix - The argument prefix.
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments, String argumentPrefix) {
    this.arguments = arguments;
    this.argumentPrefix = argumentPrefix;

    this.createArgumentsMap();
  }

  /**
   * Constructor for the CommandLineParser class.
   * @param arguments - ParserArguments
   */
  public CommandLineParser(ArrayList<ParserArgument> arguments) {
    this.arguments = arguments;

    this.createArgumentsMap();
  }

  /**
   * Returns the CommandLineParser's arguments.
   * @return the CommandLineParser's arguments.
   */
  public ArrayList<ParserArgument> getArguments() {return arguments;}

  /**
   * Returns the CommandLineParser's argument prefix.
   * @return the CommandLineParser's argument prefix.
   */
  public String getArgumentPrefix() {
    return argumentPrefix;
  }

  /**
   * Returns the HashMap of processed arguments.
   * @return the HashMap of processed arguments.
   */
  public HashMap<String, ArrayList<String>> getProcessedArgs() {
    return processedArgs;
  }

  /**
   * Returns the HashMap of ParserArguments.
   * @return the HashMap of ParserArguments.
   */
  public HashMap<String, ParserArgument> getArgumentsMap() {
    return argumentsMap;
  }

  /**
   * Creates HashMap that maps argument key with the corresponding ParserArgument object
   */
  private void createArgumentsMap() {
    for (ParserArgument arg: this.arguments){
      this.argumentsMap.put(arg.key, arg);
    }
  }

  /**
   * Processes String arguments and returns a HashMap of argument keys and values (includes validation).
   * @param args - The arguments provided by the user.
   * @throws InvalidArgumentsException - If the arguments supplied are invalid.
   */
  public HashMap<String, ArrayList<String>> processArgs(String[] args) throws InvalidArgumentsException {
    // Clear arguments from previous user input
    this.clearArgs();

    int i = 0;
    while (i < args.length) {
      String key = args[i];
      if (key.startsWith(this.argumentPrefix)) {
        // Remove argument prefix so arguments can match ParserArgument keys
        key = key.replace(this.argumentPrefix, "");
        String value = null;
        String nextArg = null;

        if (i + 1 < args.length) {
          nextArg = args[i + 1];
        }

        if (nextArg != null && !nextArg.startsWith(this.argumentPrefix)) {
          value = nextArg;
          // Move index by one to skip this argument
          i++;
        }

        // If key is not in processedArgs, initialize the value to an empty ArrayList
        // to make adding to it later easier
        if (!this.processedArgs.containsKey(key)) {
          this.processedArgs.put(key, new ArrayList());
        }

        if (value != null) {
          this.processedArgs.get(key).add(value);
        }
      }
      i++;
    }

    this.initializeArgs();
    this.validate();

    return this.processedArgs;
  }

  /**
   * Sets the values of the arguments so ParserArguments can validate their own values
   */
  public void initializeArgs(){
    for (String key: this.processedArgs.keySet()){
      ParserArgument arg = this.argumentsMap.get(key);

      if (arg != null) {
        ArrayList<String> values = this.processedArgs.get(key);

        // Due to values being initialized with an empty ArrayList first in processArgs(),
        // arguments with no values are treated as null
        if (values.size() == 0) {
          arg.setValue(null);
        } else if (arg.allowMultiple) {
          arg.setValue(values);
        } else {
          // If we're not allowing multiple calls of this same argument,
          // we will throw away other values passed by the client
          String firstValue = values.get(0);
          values.clear();
          values.add(firstValue);
          arg.setValue(values);
        }
      }
    }
  }

  /**
   * Validates the arguments
   * @throws InvalidArgumentsException  - If the arguments supplied are invalid.
   */
  public void validate() throws InvalidArgumentsException {
    // If any of the arguments given by the client are invalid, or required arguments not given,
    // the relevant ParserArgument will throw the error themselves
    for (ParserArgument arg: this.arguments){
     arg.validate(this.processedArgs);
    }
  }

  /**
   * Prints the manual so the user knows how to use the commandline.
   */
  public void printManual() {
    for (ParserArgument arg: this.arguments) {
      arg.printManual();
    }
  }

  /**
   * Clears the processedArgs HashMap to be able to take new arguments.
   */
  public void clearArgs() {
    this.processedArgs.clear();

    // Reset argument values
    for (ParserArgument arg: this.arguments){
      arg.setValue(null);
    }
  }
}
