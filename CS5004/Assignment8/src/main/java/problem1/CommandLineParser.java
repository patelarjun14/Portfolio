package problem1;
import java.util.*;

/**
 * CommandLineParser class that processes and validates command line arguments.
 */
public class CommandLineParser {

  public static final String MANUAL = " Usage:\n"
      + "--email Generate email messages. If this option is provided, then -- email-template must also be provided.\n"
      + "--email-template <path/to/file> A filename for the email template. --letter Generate letters. If this option is provided, then --letter- template must also be provided.\n"
      + "--letter-template <path/to/file> A filename for the letter template. --output-dir <path/to/folder> The folder to store all generated files. This option is required.\n"
      + "--csv-file <path/to/folder> The CSV file to process. This option is required.\n"
      + "Examples:\n"
      + "--email --email-template email-template.txt --output-dir emails -- csv-file customer.csv\n"
      + "--letter --letter-template letter-template.txt --output-dir letters - -csv-file customer.csv";

  // CLI options
  public static final String EMAIL_ARGUMENT_KEY = "--email";
  public static final String EMAIL_TEMPLATE_ARGUMENT_KEY = "--email-template";
  public static final String LETTER_ARGUMENT_KEY = "--letter";
  public static final String LETTER_TEMPLATE_ARGUMENT_KEY = "--letter-template";
  public static final String OUTPUT_ARGUMENT_KEY = "--output-dir";
  public static final String CSV_ARGUMENT_KEY = "--csv-file";

  private final String[] requiredOptions = {OUTPUT_ARGUMENT_KEY, CSV_ARGUMENT_KEY};

  public String emailTemplate;
  public String letterTemplate;
  public String csv;
  public String outputDirPath;

  /**
   * Constructor for the CommandLineParser class
   * @param args The arguments provided by the user.
   * @throws InvalidArgumentsException If the arguments supplied are invalid.
   */
  public CommandLineParser(String[] args) throws InvalidArgumentsException {
    this.processArgs(args);
  }

  /**
   * Returns the command line's required options.
   * @return the command line's required options.
   */
  public String[] getRequiredOptions() {
    return this.requiredOptions;
  }

  /**
   * Returns the command line's email template file path.
   * @return the command line's email template file path.
   */
  public String getEmailTemplate() {
    return this.emailTemplate;
  }

  /**
   * Returns the command line's letter template file path.
   * @return the command line's letter template file path.
   */
  public String getLetterTemplate() {
    return this.letterTemplate;
  }

  /**
   * Returns the command line's CSV file path.
   * @return the command line's CSV file path.
   */
  public String getCsv() {
    return this.csv;
  }

  /**
   * Returns the command line's output directory path.
   * @return the command line's output directory path.
   */
  public String getOutputDirPath() {
    return this.outputDirPath;
  }

  /**
   * Helper method to populate the instance variables.
   * @param args The args supplied by the user.
   * @throws InvalidArgumentsException If an invalid argument is provided at the command line.
   */
  private void processArgs(String[] args) throws InvalidArgumentsException {
    // Remove duplicate options
    HashMap<String, String> processedArgs = this.preprocessArgs(args);

    // check required options
    checkRequiredOptions(processedArgs);
    this.outputDirPath = processedArgs.get(OUTPUT_ARGUMENT_KEY);
    this.csv = processedArgs.get(CSV_ARGUMENT_KEY);

    // check that either email option or letter option is given
    if (!processedArgs.containsKey(EMAIL_ARGUMENT_KEY) &&
        !processedArgs.containsKey(LETTER_ARGUMENT_KEY)){
      throw new InvalidArgumentsException("Neither email option or letter option were chosen".concat(MANUAL));
    }

    // check if email option is given, email-template is also given
    if (processedArgs.containsKey(EMAIL_ARGUMENT_KEY)) {
      if (processedArgs.get(EMAIL_TEMPLATE_ARGUMENT_KEY) == null) {
        throw new InvalidArgumentsException("Email option chosen but no email template given.".concat(MANUAL));
      } else {
        this.emailTemplate = processedArgs.get(EMAIL_TEMPLATE_ARGUMENT_KEY);

        EmailGenerator emailGenerator = new EmailGenerator(this.csv, this.emailTemplate, this.outputDirPath);
        emailGenerator.generate();
      }
    }

    // check if letter option is given, letter-template is also given
    if (processedArgs.containsKey(LETTER_ARGUMENT_KEY)) {
      if (processedArgs.get(LETTER_TEMPLATE_ARGUMENT_KEY) == null) {
        throw new InvalidArgumentsException("Letter option chosen but no letter template given.".concat(MANUAL));
      } else {
        this.letterTemplate = processedArgs.get(LETTER_TEMPLATE_ARGUMENT_KEY);

        LetterGenerator letterGenerator = new LetterGenerator(this.csv, this.letterTemplate, this.outputDirPath);
        letterGenerator.generate();
      }
    }
  }

  /**
   * Removes duplicate options. CLI will only process the first valid option and will ignore other
   * occurrences of the option.
   *
   * Examples:
   *  Before: `--email --email --email-template path/to/file`
   *  After: `--email --email-template path/to/file`
   *
   *  Before: `--email --email-template path/to/file --email-template path/to/`
   *  After: `--email --email-template path/to/file`
   *
   *  Before: `--email --email-template path/to/file --email --email-template path/to/`
   *  After: `--email --email-template path/to/file`
   * @param args The arguments provided by the user.
   * @return arguments with duplicates removed
   */
  private HashMap<String, String> preprocessArgs(String[] args) {
    String OPTION_FLAG = "--";
    HashMap<String, String> processedArgs = new HashMap<>();

    int i = 0;
    while (i < args.length) {
      String key = args[i];
      if (key.startsWith(OPTION_FLAG) && !processedArgs.containsKey(key)) {
        String value = null;
        String nextArg = args[i + 1];

        if (!nextArg.startsWith(OPTION_FLAG)) {
          value = nextArg;
          // Move index by one to skip this argument
          i++;
        }
        processedArgs.put(key, value);
      }
      i++;
    }
    return processedArgs;
  }

  /**
   * Check if all required options are given
   * @param args arguments given by user
   * @throws InvalidArgumentsException - throws exception if invalid argument is entered
   */
  void checkRequiredOptions(HashMap<String, String> args) throws InvalidArgumentsException{
    for (String requiredOption : this.requiredOptions) {
      if (args.get(requiredOption) == null) {
        throw new InvalidArgumentsException(requiredOption + " option is required.".concat(MANUAL));
      }
    }
  }

  /**
   * Returns whether some other object is "equal to" this one.
   * @param o - The object we are comparing to.
   * @return whether some other object is "equal to" this one, encoded as a Boolean.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineParser that = (CommandLineParser) o;
    return Arrays.equals(this.requiredOptions, that.requiredOptions) && Objects.equals(
        this.emailTemplate, that.emailTemplate) && Objects.equals(this.letterTemplate,
        that.letterTemplate) && Objects.equals(this.csv, that.csv) && Objects.equals(
        this.outputDirPath, that.outputDirPath);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for the object, encoded as an Integer.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(this.emailTemplate, this.letterTemplate, this.csv, this.outputDirPath);
    result = 31 * result + Arrays.hashCode(this.requiredOptions);
    return result;
  }

  /**
   * Returns a string representation of the object.
   * @return a string representation of the object, encoded as a String.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "requiredOptions=" + Arrays.toString(this.requiredOptions) +
        ", emailTemplate='" + this.emailTemplate + '\'' +
        ", letterTemplate='" + this.letterTemplate + '\'' +
        ", csv='" + this.csv + '\'' +
        ", outputDirPath='" + this.outputDirPath + '\'' +
        '}';
  }
}
