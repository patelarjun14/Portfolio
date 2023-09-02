package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseStatistics {

  public Map<Course,Integer> numberOfStudentsForCourse = new HashMap<>();
  public Map<Course,Integer> numberOfAlignStudentsForCourse = new HashMap<>();
  public Map<Course,Integer> averageGradeForAllStudentsForCourse = new HashMap<>();
  public Map<Course,Integer> averageGradeForAlignStudentsForCourse = new HashMap<>();


  public void getAggregatedStatisticsOnAlignStudents(List<Student> alignStudents){
    for(Student student: alignStudents) {
      for (Course course : student.getTakenCourses()) {
        if (this.numberOfAlignStudentsForCourse.containsKey(course)) {

          // Updating map for count for Align students
          Integer valueCount = this.numberOfAlignStudentsForCourse.get(course);
          this.numberOfAlignStudentsForCourse.replace(course, valueCount + 1);

          // Updating map for GPA for Align students
          Integer valueGPA = this.averageGradeForAlignStudentsForCourse.get(course);
          Integer updatedGPA = (valueGPA+course.getGrade())/valueCount;
          this.averageGradeForAlignStudentsForCourse.replace(course,updatedGPA);
        }
        if (this.numberOfAlignStudentsForCourse.containsKey(course) == false) {

          // Updating map for count for Align students
          this.numberOfAlignStudentsForCourse.put(course, 1);

          // Updating map for GPA for Align students
          Integer valueGPA = this.averageGradeForAlignStudentsForCourse.get(course);
          this.averageGradeForAlignStudentsForCourse.replace(course,valueGPA);

        }
      }
    }
  }

  public void getAggregatedStatisticsOnAllStudents(List<Student> allStudents){
    for(Student student: allStudents) {
      for (Course course : student.getTakenCourses()) {
        if (this.numberOfStudentsForCourse.containsKey(course)) {

          // Updating map for count for Align students
          Integer valueCount = this.numberOfStudentsForCourse.get(course);
          this.numberOfStudentsForCourse.replace(course, valueCount + 1);

          // Updating map for GPA for Align students
          Integer valueGPA = this.averageGradeForAllStudentsForCourse.get(course);
          Integer updatedGPA = (valueGPA+course.getGrade())/valueCount;
          this.averageGradeForAllStudentsForCourse.replace(course,updatedGPA);
        }
        if (this.numberOfStudentsForCourse.containsKey(course) == false) {

          // Updating map for count for Align students
          this.numberOfStudentsForCourse.put(course, 1);

          // Updating map for GPA for Align students
          Integer valueGPA = this.averageGradeForAllStudentsForCourse.get(course);
          this.averageGradeForAllStudentsForCourse.replace(course,valueGPA);
        }
      }
    }
  }






}
