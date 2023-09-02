package problem1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Award {
  private String awardName;
  private String awardCategory;
  private String awardCommittee;
  private LocalDateTime dateofTheAward;

  public Award(String awardName, String awardCategory, String awardCommittee,
      LocalDate dateofTheAward) {
    this.awardName = awardName;
    this.awardCategory = awardCategory;
    this.awardCommittee = awardCommittee;
    this.dateofTheAward = dateofTheAward;
  }

  public String getAwardName() {
    return awardName;
  }

  public String getAwardCategory() {
    return awardCategory;
  }

  public String getAwardCommittee() {
    return awardCommittee;
  }

  public LocalDateTime getDateofTheAward() {
    return dateofTheAward;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Award award = (Award) o;
    return Objects.equals(awardName, award.awardName) && Objects.equals(
        awardCategory, award.awardCategory) && Objects.equals(awardCommittee,
        award.awardCommittee) && Objects.equals(dateofTheAward, award.dateofTheAward);
  }

  @Override
  public int hashCode() {
    return Objects.hash(awardName, awardCategory, awardCommittee, dateofTheAward);
  }

  @Override
  public String toString() {
    return "Award{" +
        "awardName='" + awardName + '\'' +
        ", awardCategory='" + awardCategory + '\'' +
        ", awardCommittee='" + awardCommittee + '\'' +
        ", dateofTheAward=" + dateofTheAward +
        '}';
  }
}
