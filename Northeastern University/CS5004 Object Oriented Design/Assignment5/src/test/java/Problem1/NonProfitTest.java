package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonProfitTest {

  private NonProfit testNonProfit;
  private NonProfit testNonProfit2;

  private ArrayList<Donations> list;
  private MonthlyDonations testMonthlyDonations;
  private OneTimeDonations testOneTimeDonations;
  private OneTimeDonations testOneTimeDonations2;
  private Pledges testPledgesDonations;

  private LocalDateTime localDateTime1;
  private LocalDateTime localDateTime2;
  private LocalDateTime localDateTime3;






  @BeforeEach
  void setUp() {
    localDateTime1 = LocalDateTime.of(2022,3,1,11,59,59);
    localDateTime2 = LocalDateTime.of(2022,3,1,11,59,59);

    localDateTime3 = LocalDateTime.of(2022,3,1,11,59,59);

    testOneTimeDonations = new OneTimeDonations(1000,localDateTime1);
    testOneTimeDonations2 = new OneTimeDonations(2000,localDateTime1);


    testMonthlyDonations = new MonthlyDonations(1000,localDateTime1,localDateTime2);
    testPledgesDonations = new Pledges(1000,localDateTime1,localDateTime2);



    list = new ArrayList<>();
    list.add(testPledgesDonations);
    list.add(testMonthlyDonations);
    list.add(testOneTimeDonations);

    testNonProfit = new NonProfit(list,"Northeastern");

    testNonProfit2 = new NonProfit(list,"Seattle NonProfit");

  }

  @Test
  void getDonationList() {
    assertEquals(list,testNonProfit.getDonationList());


  }

  @Test
  void setDonationList() {
  }

  @Test
  void getNameOfNonProfit() {
    assertEquals("Northeastern",testNonProfit.getNameOfNonProfit());

  }

  @Test
  void setNameOfNonProfit() {
    testNonProfit.setNameOfNonProfit("Seattle Nonprofit");
    assertEquals("Seattle Nonprofit",testNonProfit.getNameOfNonProfit());

  }

  @Test
  void testEquals() {
    NonProfit expectedobject = testNonProfit;
    assertFalse(testNonProfit2.equals(expectedobject));

  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testNonProfit);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testNonProfit.hashCode());
  }

  @Test
  void testToString() {


  }

  @Test
  void getTotalDonationsForYear() {
    assertEquals(5000,testNonProfit.getTotalDonationsForYear());
  }
}