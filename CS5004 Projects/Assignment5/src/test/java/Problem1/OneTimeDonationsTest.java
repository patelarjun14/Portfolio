package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneTimeDonationsTest {

  private OneTimeDonations testOneTimeDonations;
  private LocalDateTime localDateTime1;

  @BeforeEach
  void setUp() {
    LocalDateTime localDateTime1 = LocalDateTime.of(2022,3,1,11,59,59);
    testOneTimeDonations = new OneTimeDonations(1000,localDateTime1);
  }

  @Test
  void testToString() {

    String expectedString = "OneTimeDonations{" +
        "amount=" + testOneTimeDonations.amount +
        ", createDate=" + testOneTimeDonations.createDate +
        '}';

    assertEquals(expectedString,testOneTimeDonations.toString());

  }

  @Test
  void getTotalDonationsForYear() {
    assertEquals(1000,testOneTimeDonations.getTotalDonationsForYear(2022));


  }
}