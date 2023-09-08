package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;


class CollegeAthleteRegistryTest {

  private CollegeAthleteRegistry listTest;
  private CollegeAthleteRegistry listTest2;
  private CollegeAthlete collegeAthleteTest1;
  private CollegeAthlete collegeAthleteTest2;
  private CollegeAthlete collegeAthleteTest3;
  private CollegeAthlete collegeAthleteTest4;
  private CollegeAthlete collegeAthleteTest5;

  private Name name1;
  private Name name2;
  private Name name3;
  private Name name4;
  private Name name5;





  private LocalDate timeTest1;




  @BeforeEach
  void setUp() {



    timeTest1 = LocalDate.of(1995,12,31);


    name1 = new Name("Arjun","H","Patel","AJ");
    name2 = new Name("Alex","H","Patel","AJ");
    name3 = new Name("John","H","Patel","AJ");
    name4 = new Name("Wyatt","H","Patel","AJ");
    name5 = new Name("Cooper","H","Patel","AJ");



    collegeAthleteTest1 = new CollegeAthlete(name1,timeTest1,"Economics","United States",new Integer[]{1},"Northeastern","Northeastern",
        new String[]{"Award"},200000.00, new String[]{("Tesla")});
    collegeAthleteTest2 = new CollegeAthlete(name2,timeTest1,"Spanish","United States",new Integer[]{1},"Northeastern","Northeastern",
        new String[]{"Award"},200000.00, new String[]{("Tesla")});
    collegeAthleteTest3 = new CollegeAthlete(name3,timeTest1,"Computer Science","United States",new Integer[]{1},"Northeastern","Northeastern",
        new String[]{"Award"},200000.00, new String[]{("Tesla")});
    collegeAthleteTest4 = new CollegeAthlete(name4,timeTest1,"Math","United States",new Integer[]{1},"Northeastern","Northeastern",
        new String[]{"Award"},200000.00, new String[]{("Tesla")});
    collegeAthleteTest5 = new CollegeAthlete(name5,timeTest1,"French","United States",new Integer[]{1},"Northeastern","Northeastern",
        new String[]{"Award"},200000.00, new String[]{("Tesla")});




    listTest = new CollegeAthleteRegistry(0,null);






  }



  @Test
  void count() {
    listTest.add(collegeAthleteTest1);
    listTest.add(collegeAthleteTest2);
    listTest.add(collegeAthleteTest3);
    listTest.add(collegeAthleteTest4);
    listTest.add(collegeAthleteTest5);

    assertEquals(5,listTest.count());





  }

  @Test
  void contains() {
    listTest.add(collegeAthleteTest1);
    listTest.add(collegeAthleteTest2);
    listTest.add(collegeAthleteTest3);
    listTest.add(collegeAthleteTest4);
    listTest.add(collegeAthleteTest5);

    assertEquals(true,listTest.contains(collegeAthleteTest3));


  }

  @Test
  void remove() throws CollegeAthleteNotFoundException {

    listTest.add(collegeAthleteTest1);
    listTest.add(collegeAthleteTest2);
    listTest.add(collegeAthleteTest3);
    listTest.add(collegeAthleteTest4);
    listTest.add(collegeAthleteTest5);

    listTest.remove(collegeAthleteTest3);


    assertEquals(4,listTest.count());
    assertEquals(false,listTest.contains(collegeAthleteTest3));

  }

  @Test
  void disciplineReturn() {

    listTest.add(collegeAthleteTest1);
    listTest.add(collegeAthleteTest2);
    listTest.add(collegeAthleteTest3);
    listTest.add(collegeAthleteTest4);
    listTest.add(collegeAthleteTest5);

    assertEquals(collegeAthleteTest4,listTest.disciplineReturn("Math"));

  }
}