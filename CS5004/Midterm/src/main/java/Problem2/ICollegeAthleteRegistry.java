package Problem2;

public interface ICollegeAthleteRegistry {

  /**
   * @return Returns Integer for the number of college athletes
   * in College Athlete Registry system
   */
  int count(); //Count the number of CollegeAthletes in the CollegeAthleteRegistery

  /**
   * @param athlete An object that has the college type CollegeAthlete
   * @return A boolean (true or false)
   */
  boolean contains(CollegeAthlete athlete); // Check if a specific CollegeAthlete is included in the CollegeAthleteRegistery

  /**
   * @param athlete An object that has the college type CollegeAthlete
   */
  void add(CollegeAthlete athlete); // Add a new CollegeAthlete into the CollegeAthleteRegistery.

  /**
   * @param athlete An object that has the college type CollegeAthlete
   * @param newInformation An object that has the college type CollegeAthlete that replaces the current
   * @throws CollegeAthleteNotFoundException
   */
  void modify(CollegeAthlete athlete, CollegeAthlete newInformation)
      throws CollegeAthleteNotFoundException;

  /**
   * @param athlete An object that has the college type CollegeAthlete
   * @throws CollegeAthleteNotFoundException
   */
  void remove(CollegeAthlete athlete) throws CollegeAthleteNotFoundException; // Remove a specific CollegeAthlete from the CollegeAthleteRegistery


  /**
   * @param discipline A String that is entered for discipline
   * @return An object that has the college type CollegeAthlete
   */
  CollegeAthlete disciplineReturn(String discipline); // Return any one CollegeAthlete that competes in a discipline

  /**
   * @param amount entered as a double
   * @return Data type CollegeAthleteRegistry of college athletes
   */
  CollegeAthleteRegistry earningsReturn(Double amount); // Return all CollegeAthletes whose total earnings so far are higher than the provided

  /**
   * @param college Entered as String
   * @return Data type CollegeAthleteRegistry of college athletes
   */
  CollegeAthleteRegistry collegeReturn(String college); // All CollegeAthletes who are attending a college specified by an input argument





}
