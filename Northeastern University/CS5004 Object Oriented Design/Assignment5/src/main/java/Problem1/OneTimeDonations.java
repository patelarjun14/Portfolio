package Problem1;

import java.time.LocalDateTime;

public class OneTimeDonations extends Donations{

  public OneTimeDonations(double amount, LocalDateTime createDate) {
    super(amount, createDate);
  }



  @Override
  public String toString() {
    return "OneTimeDonations{" +
        "amount=" + amount +
        ", createDate=" + createDate +
        '}';
  }

  /**
   * @param inputYear Input year that you want to calculate
   * @return The total donations for one time donations for that year
   */
  @Override
  public double getTotalDonationsForYear(int inputYear) {
    int createdYear = this.createDate.getYear();

    if(inputYear>createdYear){
      return this.amount;
    }
    else if(inputYear == createdYear){
      return this.amount;
    }
    else if(inputYear<createdYear){
      return 0;
    }
    return 0;
  }


}
