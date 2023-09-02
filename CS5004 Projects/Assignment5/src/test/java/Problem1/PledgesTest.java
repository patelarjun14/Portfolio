package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PledgesTest {
  private Pledges testPledges;
  private Pledges testPledges2;

  private OneTimeDonations testOneTimeDonations;
  public LocalDateTime localDateTime1;
  public LocalDateTime localDateTime2;
  public LocalDateTime localDateTime3;




  @BeforeEach
  void setUp() {
    localDateTime1 = LocalDateTime.of(2022,3,1,11,59,59);
    localDateTime2 = LocalDateTime.of(2022,3,1,11,59,59);
    localDateTime3 = LocalDateTime.of(2022,4,1,11,59,59);


    testPledges = new Pledges(1000,localDateTime1,localDateTime2);
    testPledges2 = new Pledges(2000,localDateTime2,localDateTime3);

  }

  @Test
  void getProcessedTime() {
    assertEquals(localDateTime1,testPledges.getProcessedTime());
  }

  @Test
  void setProcessedTime() {
    testPledges.setProcessedTime(localDateTime3);
    assertEquals(localDateTime3,testPledges.getProcessedTime());
  }

  @Test
  void setReomveProcessedTime() {
    testPledges.setReomveProcessedTime();
  }

  @Test
  void setChangeProcessedTime() throws InvalidDateTime {
    testPledges.setChangeProcessedTime(localDateTime3);
    assertEquals(localDateTime3,testPledges.getProcessedTime());

  }

  @Test
  void testEquals() {
    Pledges expectedobject = testPledges;
    assertFalse(testPledges2.equals(expectedobject));


  }

  @Test
  void testHashCode() {
    int expectedHashcode = Objects.hashCode(testPledges);
    System.out.println("My hascode is: " + expectedHashcode);
    assertEquals(expectedHashcode,testPledges.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Pledges{" +
        "amount=" + testPledges.amount +
        ", createDate=" + testPledges.createDate +
        ", processedTime=" + testPledges.processedTime +
        '}';
    assertEquals(expectedString,testPledges.toString());

  }

  @Test
  void getTotalDonationsForYear() {
    testPledges.getTotalDonationsForYear(2022);
    assertEquals(1000,testPledges.getTotalDonationsForYear(2022));
  }
}