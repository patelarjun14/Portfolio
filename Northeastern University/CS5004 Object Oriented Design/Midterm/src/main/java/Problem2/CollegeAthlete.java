package Problem2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/*
Class CollegeAthlete stores information about college athletes - athlete's name, their date of birth,
discipline, information about the represented country, and which years has the athlete represented
that country, college attended, and the college team. The class further stores information
about the athlete's medals and recognitions, as well as their business deals and endorsements, and total earnings
thus far.
 */
public class CollegeAthlete {

  private Name athletesName;
  private LocalDate dateOfBirth;
  private String discipline;
  private String representedCountry;
  private Integer[] yearsOnNationalTeam;
  private String college;
  private String collegeTeam;
  private String[] medals;
  private Double totalEarningsThusFar;
  private String[] corporateDeals;

  public CollegeAthlete(Name athletesName, LocalDate dateOfBirth, String discipline, String representedCountry,
      Integer[] yearsOnNationalTeam, String college, String collegeTeam, String[] medals,
      Double totalEarningsThusFar, String[] corporateDeals) {
    this.athletesName = athletesName;
    this.dateOfBirth = dateOfBirth;
    this.discipline = discipline;
    this.representedCountry = representedCountry;
    this.yearsOnNationalTeam = yearsOnNationalTeam;
    this.college = college;
    this.collegeTeam = collegeTeam;
    this.medals = medals;
    this.totalEarningsThusFar = totalEarningsThusFar;
    this.corporateDeals = corporateDeals;
  }

  public Name getAthletesName() {
    return athletesName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public String getDiscipline() {
    return discipline;
  }

  public String getRepresentedCountry() {
    return representedCountry;
  }

  public Integer[] getYearsOnNationalTeam() {
    return yearsOnNationalTeam;
  }

  public String getCollege() {
    return college;
  }

  public String getCollegeTeam() {
    return collegeTeam;
  }

  public String[] getMedals() {
    return medals;
  }

  public Double getTotalEarningsThusFar() {
    return totalEarningsThusFar;
  }

  public String[] getCorporateDeals() {
    return corporateDeals;
  }

  public void setAthletesName(Name athletesName) {
    this.athletesName = athletesName;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDiscipline(String discipline) {
    this.discipline = discipline;
  }

  public void setRepresentedCountry(String representedCountry) {
    this.representedCountry = representedCountry;
  }

  public void setYearsOnNationalTeam(Integer[] yearsOnNationalTeam) {
    this.yearsOnNationalTeam = yearsOnNationalTeam;
  }

  public void setCollege(String college) {
    this.college = college;
  }

  public void setCollegeTeam(String collegeTeam) {
    this.collegeTeam = collegeTeam;
  }

  public void setMedals(String[] medals) {
    this.medals = medals;
  }

  public void setTotalEarningsThusFar(Double totalEarningsThusFar) {
    this.totalEarningsThusFar = totalEarningsThusFar;
  }

  public void setCorporateDeals(String[] corporateDeals) {
    this.corporateDeals = corporateDeals;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CollegeAthlete that = (CollegeAthlete) o;
    return Objects.equals(athletesName, that.athletesName) && Objects.equals(dateOfBirth,
        that.dateOfBirth) && Objects.equals(discipline, that.discipline)
        && Objects.equals(representedCountry, that.representedCountry)
        && Arrays.equals(yearsOnNationalTeam, that.yearsOnNationalTeam)
        && Objects.equals(college, that.college) && Objects.equals(collegeTeam, that.collegeTeam)
        && Arrays.equals(medals, that.medals)
        && Objects.equals(totalEarningsThusFar, that.totalEarningsThusFar)
        && Arrays.equals(corporateDeals, that.corporateDeals);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(athletesName, dateOfBirth, discipline,
        representedCountry, college, collegeTeam, totalEarningsThusFar);
    result = 31 * result + Arrays.hashCode(yearsOnNationalTeam);
    result = 31 * result + Arrays.hashCode(medals);
    result = 31 * result + Arrays.hashCode(corporateDeals);
    return result;
  }

  @Override
  public String toString() {
    return "CollegeAthlete{" +
        "athletesName=" + athletesName +
        ", dateOfBirth=" + dateOfBirth +
        ", discipline='" + discipline + '\'' +
        ", representedCountry='" + representedCountry + '\'' +
        ", yearsOnNationalTeam=" + Arrays.toString(yearsOnNationalTeam) +
        ", college='" + college + '\'' +
        ", collegeTeam='" + collegeTeam + '\'' +
        ", medals=" + Arrays.toString(medals) +
        ", totalEarningsThusFar=" + totalEarningsThusFar +
        ", corporateDeals=" + Arrays.toString(corporateDeals) +
        '}';
  }
}

