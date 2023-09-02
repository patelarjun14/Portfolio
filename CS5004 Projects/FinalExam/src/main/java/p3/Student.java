package p3;

import java.util.List;
import java.util.Objects;

/*
Class Student contains information about a student - students name and their studentID, academic program a student is
enrolled into, as well as the list of courses the student has taken.
 */
public class Student {

  private Name name;
  private String studentID;
  private String academicProgram;
  private List<Course> takenCourses;

  private static String COURSE5001 = "CS 5001";
  private static String COURSE5002 = "CS 5002";
  private static String COURSE5004 = "CS 5004";
  private static String COURSE5008 = "CS 5008";
  private static Integer FOUR = 4;

  public Student(Name name, String studentID, String academicProgram, List<Course> takenCourses) {
    this.name = name;
    this.studentID = studentID;
    this.academicProgram = academicProgram;
    this.takenCourses = takenCourses;
  }

  public Name getName() {
    return name;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getAcademicProgram() {
    return academicProgram;
  }

  public List<Course> getTakenCourses() {
    return takenCourses;
  }

  public Float getGPA(){
    Integer gradeSum = 0;
    for (Course course : this.takenCourses){
      gradeSum += course.getGrade();
    }
    return Float.valueOf(gradeSum/this.takenCourses.size());
  }


  public Boolean isAlignStudent(){

    Integer count = 0;
    for(Course courseInList: this.getTakenCourses()){
      if(courseInList.getCourseCode().equals(COURSE5001) &&
          courseInList.getCourseCode().equals(COURSE5002) &&
          courseInList.getCourseCode().equals(COURSE5004) &&
          courseInList.getCourseCode().equals(COURSE5008)
      ) {
      }
    }
    return count.equals(FOUR);
  }


  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    Student student = (Student) o;
    return Objects.equals(getName(), student.getName()) &&
        Objects.equals(getStudentID(), student.getStudentID()) &&
        Objects.equals(getAcademicProgram(), student.getAcademicProgram()) &&
        Objects.equals(getTakenCourses(), student.getTakenCourses());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getStudentID(), getAcademicProgram(), getTakenCourses());
  }

  @Override
  public String toString() {
    return "Student{" +
        "name=" + name +
        ", studentID='" + studentID + '\'' +
        ", academicProgram='" + academicProgram + '\'' +
        ", takenCourses=" + takenCourses +
        '}';
  }
}
