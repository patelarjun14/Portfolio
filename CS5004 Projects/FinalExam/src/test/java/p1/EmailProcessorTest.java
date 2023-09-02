package p1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailProcessorTest {

  private EmailProcessor emailProcessorTest;
  private EmailAccount emailAccountTest;
  private Name name1;

  private List<String> list1;
  private List<String> list2;
  private List<String> list3;
  private List<String> list4;

  private Email email1;
  private Email email2;
  private Email email3;
  private Email email4;
  private Email email5;
  private Email email6;

  private LocalDate date1;
  private LocalDate date2;
  private LocalDate date3;
  private LocalDate date4;
  private LocalDate date5;
  private LocalDate date6;


  @BeforeEach
  void setUp() {
    name1 = new Name("Arjun","Patel","Patel");

    date1 = LocalDate.of(2020,12,25);
    date2 = LocalDate.of(2020,2,16);
    date3 = LocalDate.of(2020,12,25);
    date3 = LocalDate.of(2021,4,25);
    date4 = LocalDate.of(2022,1,14);
    date5 = LocalDate.of(2019,1,14);
    date6 = LocalDate.of(2020,5,20);

    list1 = new ArrayList<>();
    list1.add("Arjun");

    list2 = new ArrayList<>();
    list2.add("Tina");

    list3 = new ArrayList<>();
    list3.add("Seema");

    list4 = new ArrayList<>();
    list4.add("Hiten");



    email1 = new Email("Tina",list1,list4,true,"money",date1);
    email2 = new Email("Arjun",list2,list4,true,"Birthday",date2);
    email3 = new Email("Hiten",list1,list2,true,"money",date3);
    email4 = new Email("Seema",list1,list2,false,"money",date4);
    email5 = new Email("Arjun",list3,list2,true,"moving out",date5);
    email6 = new Email("Tina",list3,list1,false,"travel plans",date6);

    List<Email> recieved = new ArrayList<>();
    recieved.add(email1);
    recieved.add(email3);
    recieved.add(email4);

    List<Email> sent = new ArrayList<>();
    sent.add(email2);
    sent.add(email5);



    emailAccountTest = new EmailAccount(name1,"patel.arjun1@northeastern.edu",recieved,sent);

    emailProcessorTest = new EmailProcessor(emailAccountTest);


  }

  @Test
  void mysteryMethod() {

    List<String> output1 = emailProcessorTest.mysteryMethod(date2,"Birthday");

    assertEquals(1,output1.size());
    assertEquals("Birthday",output1.get(0));


  }

  @Test
  void filterSentEmailsBySenderRecipientAndDate() {

    List<Email> output = emailProcessorTest.filterSentEmailsBySenderRecipientAndDate("Arjun","Seema",date5);
    assertEquals(1,output.size());
    assertEquals(email5,output.get(0));



  }
}