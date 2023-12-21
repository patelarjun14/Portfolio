package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


class MonthlyDonationsTest {
  private MonthlyDonations testMonthlyDonations1;
  private MonthlyDonations testMonthlyDonations2;


  private LocalDateTime localDateTime1;
  private LocalDateTime localDateTime2;



  @BeforeEach
  void setUp() {
    localDateTime1 = LocalDateTime.of(2022,3,1,11,59,59);
    localDateTime2 = LocalDateTime.of(2023,3,1,11,59,59);



    testMonthlyDonations1 = new MonthlyDonations(1000,localDateTime1,localDateTime2);
    testMonthlyDonations2 = new MonthlyDonations(1000,localDateTime1);

  }

//  @Test
//  void getCancellationTime() {
//    assertEquals(localDateTime1,testMonthlyDonations2.getCancellationTime());
//  }

  @Test
  void setCancellationTime() {
    testMonthlyDonations2.setCancellationTime(localDateTime2);
    assertEquals(localDateTime2,testMonthlyDonations2.getCancellationTime());

  }

  @Test
  void setChangeCancellationTime() throws InvalidDateTime {
    testMonthlyDonations2.setChangeCancellationTime(localDateTime2);
    assertEquals(localDateTime2,testMonthlyDonations1.getCancellationTime());

  }

  @Test
  void testEquals() {
    MonthlyDonations expectedobject = testMonthlyDonations2;
    assertFalse(testMonthlyDonations1.equals(expectedobject));


  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testMonthlyDonations1);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testMonthlyDonations1.hashCode());

  }

  @Test
  void testToString() {
    String expectedString = "MonthlyDonations{" +
        "amount=" + testMonthlyDonations1.amount +
        ", createDate=" + testMonthlyDonations1.createDate +
        ", cancellationTime=" + testMonthlyDonations1.cancellationTime +
        '}';

    assertEquals(expectedString, testMonthlyDonations1.toString());

  }

  @Test
  void getTotalDonationsForYear() {
    assertEquals(3000,testMonthlyDonations1.getTotalDonationsForYear(2022));

  }
}