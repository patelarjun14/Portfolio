package Problem1;

import java.util.Objects;

//Create Course node structure
public class CourseNode {
  public Course course;
  public CourseNode nextcourseNode;

//Create CourseNode constructor
  public CourseNode(Course course, CourseNode nextcourseNode) {
    this.course = course;
    this.nextcourseNode = nextcourseNode;
  }

//Create getter function for course
  public Course getCourse() {
    return course;
  }

//Create setter function for course
  public void setCourse(Course course) {
    this.course = course;
  }

//Create getter function for NextCourse
  public CourseNode getNextcourseNode() {
    return nextcourseNode;
  }

//Create setter function for NextCourse
  public void setNextcourseNode(CourseNode nextcourseNode) {
    this.nextcourseNode = nextcourseNode;
  }

//Create Equals Objects
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseNode that = (CourseNode) o;
    return Objects.equals(course, that.course) && Objects.equals(nextcourseNode,
        that.nextcourseNode);
  }

//Create Hashcode
  @Override
  public int hashCode() {
    return Objects.hash(course, nextcourseNode);
  }

//Create override function
  @Override
  public String toString() {
    return "CourseNode{" +
        "course=" + course +
        ", nextcourseNode=" + nextcourseNode +
        '}';
  }
}
