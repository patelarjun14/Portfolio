package p2;

import java.util.List;
import java.util.Objects;

/*
Class Student contains information about a student - students name and their studentID, academic program a student is
enrolled into, as well as the list of courses the student has taken.
 */
public class Student implements Comparable<Student> {

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
      System.out.println(gradeSum);

    }
    System.out.println(Float.valueOf(gradeSum/this.takenCourses.size()));
    return Float.valueOf(gradeSum/this.takenCourses.size());
  }

  /**
   * Compares this object with the specified object for order.  Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * <p>The implementor must ensure
   * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
   * for all {@code x} and {@code y}.  (This
   * implies that {@code x.compareTo(y)} must throw an exception iff
   * {@code y.compareTo(x)} throws an exception.)
   *
   * <p>The implementor must also ensure that the relation is transitive:
   * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
   * {@code x.compareTo(z) > 0}.
   *
   * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
   * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
   * all {@code z}.
   *
   * <p>It is strongly recommended, but <i>not</i> strictly required that
   * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
   * class that implements the {@code Comparable} interface and violates
   * this condition should clearly indicate this fact.  The recommended
   * language is "Note: this class has a natural ordering that is
   * inconsistent with equals."
   *
   * <p>In the foregoing description, the notation
   * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
   * <i>signum</i> function, which is defined to return one of {@code -1},
   * {@code 0}, or {@code 1} according to whether the value of
   * <i>expression</i> is negative, zero, or positive, respectively.
   *
   * @param otherStudent the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object
   * is less than, equal to, or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it
   *                              from being compared to this object.
   */
  @Override
  public int compareTo(Student otherStudent) {
    return this.getGPA().compareTo(otherStudent.getGPA());

  }


  public Boolean alignFourClasses(){

    Integer count = 0;
    for(Course courseInList: this.takenCourses){
      if(courseInList.getCourseCode().equals(COURSE5001) &&
          courseInList.getCourseCode().equals(COURSE5002) &&
          courseInList.getCourseCode().equals(COURSE5004) &&
          courseInList.getCourseCode().equals(COURSE5008)
      ) {
      }
    }
    return FOUR == count;
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
