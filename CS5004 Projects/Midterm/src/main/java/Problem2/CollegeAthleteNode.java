package Problem2;

import java.util.Objects;

public class CollegeAthleteNode {
  public CollegeAthlete collegeAthlete;
  public CollegeAthleteNode nextCollegeAthleteNode;

  public CollegeAthleteNode(CollegeAthlete collegeAthlete,
      CollegeAthleteNode nextCollegeAthleteNode) {
    this.collegeAthlete = collegeAthlete;
    this.nextCollegeAthleteNode = nextCollegeAthleteNode;
  }


  public CollegeAthlete getCollegeAthlete() {
    return collegeAthlete;
  }

  public void setCollegeAthlete(CollegeAthlete collegeAthlete) {
    this.collegeAthlete = collegeAthlete;
  }

  public CollegeAthleteNode getNextCollegeAthleteNode() {
    return nextCollegeAthleteNode;
  }

  public void setNextCollegeAthleteNode(CollegeAthleteNode nextCollegeAthleteNode) {
    this.nextCollegeAthleteNode = nextCollegeAthleteNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollegeAthleteNode that = (CollegeAthleteNode) o;
    return Objects.equals(collegeAthlete, that.collegeAthlete) && Objects.equals(
        nextCollegeAthleteNode, that.nextCollegeAthleteNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collegeAthlete, nextCollegeAthleteNode);
  }

  @Override
  public String toString() {
    return "CollegeAthleteNode{" +
        "collegeAthlete=" + collegeAthlete +
        ", nextCollegeAthleteNode=" + nextCollegeAthleteNode +
        '}';
  }
}
