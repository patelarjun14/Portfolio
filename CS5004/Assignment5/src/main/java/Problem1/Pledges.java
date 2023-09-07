package Problem1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Pledges extends Donations {


  LocalDateTime processedTime;

  public Pledges(double amount, LocalDateTime createDate, LocalDateTime processedTime) {
    super(amount, createDate);
    this.processedTime = processedTime;
  }

  public LocalDateTime getProcessedTime() {
    return processedTime;
  }

  public void setProcessedTime(LocalDateTime processedTime) {
    this.processedTime = processedTime;
  }

  public void setReomveProcessedTime(){
    this.processedTime = null;

  }

  public void setChangeProcessedTime(LocalDateTime input) throws InvalidDateTime {
    // Input data
    int inputYear = input.getYear();
    int inputMonth = input.getMonthValue();
    int inputDay = input.getDayOfMonth();

    // Object data
    int createdYear = this.createDate.getYear();
    int createdMonth = this.createDate.getMonthValue();
    int createdDay = this.createDate.getDayOfMonth();

    // Truth gate
    Boolean truth_gate = ((inputYear >= createdYear) && (inputMonth >= createdMonth) && (
        inputDay >= createdDay));

    if (truth_gate) {
      this.processedTime = input;
    } else {
      throw new InvalidDateTime("Date cannot be less than the created date");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pledges pledges = (Pledges) o;
    return Objects.equals(processedTime, pledges.processedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processedTime);
  }

  @Override
  public String toString() {
    return "Pledges{" +
        "amount=" + amount +
        ", createDate=" + createDate +
        ", processedTime=" + processedTime +
        '}';
  }

  /**
   * @param inputYear Input year that you want to calculate
   * @return Total amount made by pledges for that year
   */
  @Override
  public double getTotalDonationsForYear(int inputYear) {
    // Input Year data

    // Processed data
    int processedYear = this.processedTime.getYear();

    if(inputYear>processedYear){
      return this.amount;
    }
    else if(inputYear == processedYear){
      return this.amount;
    }
    else if(inputYear<processedYear){
      return 0;
    }
    else {
      return 0;
    }
  }

}
