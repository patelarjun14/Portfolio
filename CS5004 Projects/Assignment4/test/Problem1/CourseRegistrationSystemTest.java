package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseRegistrationSystemTest {
  private CourseRegistrationSystem testCourseRegistrationSystem;
  private Course firstCourse;
  private Course secondCourse;
  private Course thirdCourse;
  private Course fourthCourse;

  @BeforeEach
  void setUp() {
    firstCourse = new Course("Math","Graduate",2543);
    secondCourse = new Course("English","Undergraduate",2233);
    thirdCourse = new Course("Computer Science", "Graduate", 2111);
    fourthCourse = new Course("Spanish","Graduate",3222);

    testCourseRegistrationSystem = new CourseRegistrationSystem(4,
        new CourseNode(firstCourse,
            new CourseNode(secondCourse,
                new CourseNode(thirdCourse,
                    new CourseNode(fourthCourse,null)))));
  }

  @Test
  void append() {

    CourseRegistrationSystem testCourseRegistrationSystem_1 = new CourseRegistrationSystem(1,new CourseNode(
        firstCourse,null));
    testCourseRegistrationSystem_1.append(secondCourse);
    assertEquals(2,testCourseRegistrationSystem_1.count());
    assertEquals(1,testCourseRegistrationSystem_1.indexOfCourse(firstCourse));
    assertEquals(2,testCourseRegistrationSystem_1.indexOfCourse(secondCourse));




  }

  @Test
  void add() {
    CourseRegistrationSystem testCourseRegistrationSystem_1 = new CourseRegistrationSystem(1,new CourseNode(
        firstCourse,null));
    testCourseRegistrationSystem_1.add(secondCourse);
    assertEquals(2,testCourseRegistrationSystem_1.count());

    assertEquals(1,testCourseRegistrationSystem_1.indexOfCourse(secondCourse));
    assertEquals(2,testCourseRegistrationSystem_1.indexOfCourse(firstCourse));

  }

  @Test
  void remove() throws CourseNotFoundException { // to test not found excpetion use assertthrows with class
    testCourseRegistrationSystem.remove(firstCourse);
    assertEquals(3,testCourseRegistrationSystem.count());
    assertEquals(false,testCourseRegistrationSystem.contains(firstCourse));


    Course newcourse = new Course("English","Masters",24123);
    CourseNotFoundException coursenotfound = new CourseNotFoundException("");




  }

  @Test
  void contains() {
    Course fourthCourse = new Course("Spanish","Graduate",3222);
    assertEquals(true,testCourseRegistrationSystem.contains(fourthCourse));

  }

  @Test
  void indexOfCourse() {
    Course thirdCourse = new Course("Computer Science", "Graduate", 2111);
    assertEquals(3,testCourseRegistrationSystem.indexOfCourse(thirdCourse));

  }

  @Test
  void get() {
    Course errorCourse = new Course("","",0);
    assertEquals(firstCourse,testCourseRegistrationSystem.get(1));
    assertEquals(secondCourse,testCourseRegistrationSystem.get(2));
    assertEquals(thirdCourse,testCourseRegistrationSystem.get(3));
    assertEquals(fourthCourse,testCourseRegistrationSystem.get(4));
    assertEquals(errorCourse,testCourseRegistrationSystem.get(5));




  }

  @Test
  void isEmpty() {
    assertEquals(false,testCourseRegistrationSystem.isEmpty());
  }
}
