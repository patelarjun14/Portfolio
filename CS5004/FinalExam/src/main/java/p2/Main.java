package p2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import p1.Name;

public class Main {

  public static void main(String[] args) {

    GraduateCoursesComparator graduateCoursesComparatorTest = new GraduateCoursesComparator();

    LocalDate date1 = LocalDate.of(2020,12,31);

    Course course1 = new Course("CS","GRAD_",date1,3);
    Course course2 = new Course("Math","GRAD_",date1,4);
    Course course3 = new Course("CS","CS",date1,4);

    List<Course> list1 = new ArrayList<>();
    list1.add(course1);

    List<Course> list2 = new ArrayList<>();

    list2.add(course2);
    list2.add(course3);
    list2.add(course3);
    list2.add(course3);
    list2.add(course3);

    p2.Name name1 = new p2.Name("Arjun","Patel","Patel");
    p2.Name name2 = new p2.Name("Tina","Patel","Patel");

    Student studentTest1 = new Student(name1,"234","CS",list1);
    Student studentTest2 = new Student(name2,"224","CS",list2);

    // should be -1
    System.out.println(graduateCoursesComparatorTest.compare(studentTest1,studentTest2));

    // should be 1
    System.out.println(graduateCoursesComparatorTest.compare(studentTest2,studentTest1));


    //less than
    System.out.println("Test2: "+ studentTest1.compareTo(studentTest2));

    // Greater than
    System.out.println("Test2: "+ studentTest2.compareTo(studentTest1));


  }

}
