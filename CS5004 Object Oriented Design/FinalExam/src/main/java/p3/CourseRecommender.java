package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseRecommender {

  private List<Student> students;
  private List<Student> alignStudents;
  Map<String, CourseStatistics> map;



  public CourseRecommender(List<Student> students, List<Student> alignStudents,
      Map<String, CourseStatistics> map) {
    this.students = students;
    this.alignStudents = alignStudents;
    this.map = map;
  }

  public CourseRecommender(List<Student> students) {
    this.students = students;
  }


// private List<Student> filterOutAlignStudents(List<Student> allStudents). This methods takes a list of
// all students, and returns a filtered list, containing only ALIGN students. For the purpose of this
// problem, ALIGN students are those students who have taken any of the courses with course code
// "CS 5001", "CS 5002", "CS 5004" or "CS 5008.

  private List<Student> filterOutAlignStudents(List<Student> allStudents){
    return allStudents.stream().filter(x->x.isAlignStudent().equals(true)).collect(Collectors.toList());

  }



  private Map<String, CourseStatistics> computeCollegeCoursesStatistics(List<Student> student) {
    CourseStatistics newStats = new CourseStatistics();

    // update all student information
    newStats.getAggregatedStatisticsOnAllStudents(student);

    List<Student> filteredAlignedStudents = this.filterOutAlignStudents(student);

    // update all align information
    newStats.getAggregatedStatisticsOnAlignStudents(filteredAlignedStudents);

    for (Student studentList : student) {
      for (Course course : studentList.getTakenCourses()) {
        if (this.map.containsKey(course.getCourseName()) == false) {
          this.map.put(course.getCourseName(), newStats);
        }
      }
    }

    return this.map;
  }



  public List<Course> recommendCourses(Student student, CourseStatistics statistics) {

    List<Course> listOfCoursesTakenByStudent = student.getTakenCourses();
    List<Course> recommendedCourses = new ArrayList<>();

    // most taken
    Course recommended1 = null;
    Integer compare1 = 0;

    // highest GPA
    Course recommended2 = null;
    Integer compare2 = 0;

    // most taken by align students
    Course recommended3 = null;
    Integer compare3 = 0;

    for (Course course : statistics.numberOfStudentsForCourse.keySet()) {
      if (recommended1.equals(null) && (listOfCoursesTakenByStudent.contains(course) == false)) {

        recommended1 = course;
        compare1 = statistics.numberOfStudentsForCourse.get(course);
      }
      if (statistics.numberOfStudentsForCourse.get(course) > compare1 && (
          listOfCoursesTakenByStudent.contains(course) == false)) {
        recommended1 = course;
        compare1 = statistics.numberOfStudentsForCourse.get(course);
      }
    }
    for (Course course : statistics.averageGradeForAllStudentsForCourse.keySet()) {
      if (recommended2.equals(null) && (listOfCoursesTakenByStudent.contains(course) == false)) {

        recommended2 = course;
        compare2 = statistics.averageGradeForAllStudentsForCourse.get(course);
      }
      if (statistics.averageGradeForAllStudentsForCourse.get(course) > compare2 && (
          listOfCoursesTakenByStudent.contains(course) == false)) {
        recommended2 = course;
        compare2 = statistics.numberOfStudentsForCourse.get(course);
      }
    }

    for (Course course : statistics.numberOfAlignStudentsForCourse.keySet()) {
      if (recommended3.equals(null) && (listOfCoursesTakenByStudent.contains(course) == false)) {

        recommended3 = course;
        compare3 = statistics.averageGradeForAllStudentsForCourse.get(course);
      }
      if (statistics.numberOfAlignStudentsForCourse.get(course) > compare3 && (
          listOfCoursesTakenByStudent.contains(course) == false)) {
        recommended3 = course;
        compare3 = statistics.numberOfAlignStudentsForCourse.get(course);
      }
    }

    recommendedCourses.add(0, recommended1);
    recommendedCourses.add(1, recommended2);
    recommendedCourses.add(3, recommended2);

    return recommendedCourses;

  }


}
