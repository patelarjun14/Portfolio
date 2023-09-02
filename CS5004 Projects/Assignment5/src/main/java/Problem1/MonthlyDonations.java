package Problem1;


import java.time.LocalDateTime;
import java.util.Objects;

public class MonthlyDonations extends Donations{
  LocalDateTime cancellationTime;

  public MonthlyDonations(double amount, LocalDateTime createDate,
      LocalDateTime cancellationTime) {
    super(amount, createDate);
    this.cancellationTime = cancellationTime;
  }

  public MonthlyDonations(double amount, LocalDateTime createDate){
    super(amount, createDate);
  }

  public LocalDateTime getCancellationTime() {
    return cancellationTime;
  }

  public void setCancellationTime(LocalDateTime cancellationTime) {
    this.cancellationTime = cancellationTime;
  }

  /**
   * @param cancellationTime Enter in cancelation time you would like to set
   * @throws InvalidDateTime Throws an error message
   */
  public void setChangeCancellationTime(LocalDateTime cancellationTime) throws InvalidDateTime {

    int newCancellationYear = cancellationTime.getYear();
    int newCancellationMonth = cancellationTime.getMonthValue();
    int newCancellationDay = cancellationTime.getDayOfMonth();

    Boolean truth_gate = ((newCancellationYear >= this.createDate.getYear()) && (newCancellationMonth >= this.createDate.getMonthValue()) && (newCancellationDay >= this.createDate.getDayOfMonth()));

    if( truth_gate){
      this.cancellationTime=cancellationTime;
    }
    else {
      throw new InvalidDateTime("Date cannot be less than current cancellation time");
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
    MonthlyDonations that = (MonthlyDonations) o;
    return Objects.equals(cancellationTime, that.cancellationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationTime);
  }

  @Override
  public String toString() {
    return "MonthlyDonations{" +
        "amount=" + amount +
        ", createDate=" + createDate +
        ", cancellationTime=" + cancellationTime +
        '}';
  }

  /**
   * @param inputYear Input year that you want to calculate
   * @return the total monthly donations for that year
   */
  @Override
  public double getTotalDonationsForYear(int inputYear) {
        // Input Year data

    // Cancellation data
    //
    int cancellationYear = this.cancellationTime.getYear();
    int cancellationMonth = this.cancellationTime.getMonthValue();

    int createdYear = this.createDate.getYear();
    int createdMonth = this.createDate.getMonthValue();

    if(cancellationYear == inputYear) {
      int months = cancellationMonth -0;
      double total_donations = months*this.amount;
      return total_donations;
    }
    else if((cancellationYear > inputYear) && (createdYear == inputYear)){
      double total_donations = (createdMonth) * this.amount;
      return total_donations;
    }
    else if((cancellationYear > inputYear) && (createdYear < inputYear)) {
      double total_donations = 12 * this.amount;
      return total_donations;
    }
    else if(inputYear > cancellationYear) {
      return 0;
    }
    else if(this.cancellationTime == null){
      double total_donations = 12 * this.amount;
      return total_donations;
    }
    else{
      return 0;
    }


  }


}




