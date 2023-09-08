package problem1.Functionality;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface of a functionality for a command line parser
 */
public interface Functionality {
  /**
   * Runs Functionality
   * @param arguments HashMap representation of arguments from user input
   */
  public void run(HashMap<String, ArrayList<String>> arguments);
}
