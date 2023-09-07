package Problem1;

import java.time.LocalDateTime;
import java.util.Objects;

abstract class Donations {
  double amount;
  LocalDateTime createDate;


  public Donations(double amount, LocalDateTime createDate) {
    this.amount = amount;
    this.createDate = createDate;
  }

  public double getAmount() {
    return amount;
  }


  public void setAmount(double amount) {
    this.amount = amount;
  }


  public LocalDateTime getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate is the date that it was created (if you are setting new value)
   */
  public void setCreateDate(LocalDateTime createDate) {
    this.createDate = createDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Donations donations = (Donations) o;
    return Double.compare(donations.amount, amount) == 0 && Objects.equals(
        createDate, donations.createDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, createDate);
  }

  @Override
  public String toString() {
    return "Donations{" +
        "amount=" + amount +
        ", createDate=" + createDate +
        '}';
  }

  /**
   * @param inputYear Input year that you want to calculate
   * @return the total donations for that year
   */
  public abstract double getTotalDonationsForYear(int inputYear);


  }
