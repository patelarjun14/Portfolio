package Problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseNodeTest {
  private CourseNode testCoursenode;
  private Course headCourse;
  private CourseNode nextNode;
  private Course tailCourse;

  @BeforeEach
  void setUp() {
    headCourse = new Course("Computer Science","Graduate",2234);
    nextNode = new CourseNode(tailCourse,null);
    testCoursenode = new CourseNode(headCourse,nextNode);

  }

  @Test
  void getCourse() {
    assertEquals(headCourse, testCoursenode.getCourse());

  }

  @Test
  void setCourse() {
    testCoursenode.setCourse(headCourse);
    assertEquals(headCourse,testCoursenode.getCourse());

  }

  @Test
  void getNextcourseNode() {
    assertEquals(nextNode,testCoursenode.getNextcourseNode());
  }

  @Test
  void setNextcourseNode() {
    testCoursenode.setNextcourseNode(nextNode);
    assertEquals(nextNode,testCoursenode.getNextcourseNode());
  }

  @Test
  void testEquals() {
    Course coursehead = new Course("Math","Master",2234);
    CourseNode expectedObject = new CourseNode(coursehead,null);
    CourseNode testObject = new CourseNode(coursehead,null);
    assertTrue(testObject.equals(expectedObject) && expectedObject.equals(testObject) && testObject.hashCode() == expectedObject.hashCode());
    assertFalse(testCoursenode.equals(expectedObject));

  }



  @Test
  void testToString() {
    String expected = "CourseNode{" +
        "course=" + testCoursenode.course +
        ", nextcourseNode=" + testCoursenode.nextcourseNode +
        '}';
    assertEquals(expected,testCoursenode.toString());
  }
}