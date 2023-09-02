package Problem1;

import java.util.ArrayList;
import java.util.Objects;

public class NonProfit {


  public ArrayList<Donations> donationList;
  public String nameOfNonProfit;

  public NonProfit(ArrayList<Donations> donationList, String nameOfNonProfit) {
    this.donationList = donationList;
    this.nameOfNonProfit = nameOfNonProfit;
  }

  public ArrayList<Donations> getDonationList() {
    return donationList;
  }

  public void setDonationList(ArrayList<Donations> donationList) {
    this.donationList = donationList;
  }

  public String getNameOfNonProfit() {
    return nameOfNonProfit;
  }

  public void setNameOfNonProfit(String nameOfNonProfit) {
    this.nameOfNonProfit = nameOfNonProfit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(donationList, nonProfit.donationList) && Objects.equals(
        nameOfNonProfit, nonProfit.nameOfNonProfit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(donationList, nameOfNonProfit);
  }

  @Override
  public String toString() {
    return "NonProfit{" +
        "donationList=" + donationList +
        ", nameOfNonProfit='" + nameOfNonProfit + '\'' +
        '}';
  }

  /**
   * @return Return total donations for that year (all donations)
   */
  public Double getTotalDonationsForYear() {
    double amount = 0.0;
    for (Donations s : this.donationList) {
      amount = amount + s.getTotalDonationsForYear(2022);
    }
    return amount;
  }
}



