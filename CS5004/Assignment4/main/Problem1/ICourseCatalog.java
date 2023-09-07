package Problem1;

//Create CourseCatalog Interface
public interface ICourseCatalog {

  void append(Course course);

  void add(Course course);

  void remove(Course course) throws CourseNotFoundException;

  boolean contains(Course course);

  int indexOfCourse(Course course);

  Course get(Integer index);

  boolean isEmpty();

  int count();
}
