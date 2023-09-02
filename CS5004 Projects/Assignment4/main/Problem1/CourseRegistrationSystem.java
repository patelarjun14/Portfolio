package Problem1;

//Create CourseRegistrationSystem structure
public class CourseRegistrationSystem implements ICourseCatalog{
  //Magic Numbers
  private static final int ZERO = 0;
  private static final int ONE = 1;

  private Integer numCourses;
  private CourseNode firstCourse;

//Create CourseRegistrationSystem constructor
  public CourseRegistrationSystem(Integer numCourses, CourseNode firstCourse) {
    this.numCourses = numCourses;
    this.firstCourse = firstCourse;
  }

//Create append function,
  @Override
  public void append(Course course) {
    CourseNode newCourseNode = new CourseNode(course, null);
    if (this.numCourses == ZERO) {
      this.firstCourse = newCourseNode;

    } else {
      CourseNode currNode = this.firstCourse;
      while (currNode.getNextcourseNode() != null) {
        currNode = currNode.getNextcourseNode();
      }
      currNode.setNextcourseNode(newCourseNode);
      this.numCourses++;
        }
  }
 //Create add function
  @Override
  public void add(Course course) {
    CourseNode newCourse = new CourseNode(course, this.firstCourse);
    this.firstCourse = newCourse;
    this.numCourses++;

  }
//Create remove function
  @Override
  public void remove(Course course) throws CourseNotFoundException{
    if(this.contains(course)) {
      CourseNode currNode = this.firstCourse;
      CourseNode prevNode = null;
      while (!currNode.getCourse().equals(course)) {
        prevNode = currNode;
        currNode = currNode.getNextcourseNode();
      }
      if(prevNode == null) {
        this.firstCourse = this.firstCourse.getNextcourseNode();
        this.numCourses--;
      }
      else{
        prevNode.setNextcourseNode(currNode.getNextcourseNode());
        this.numCourses--;

      }
    }
    else{
        throw new CourseNotFoundException("This course is not a part of the system");
      }
  }

//Create contains function
  @Override
  public boolean contains(Course course) {
    CourseNode currCourse = this.firstCourse;
    while (currCourse != null) {
      if (currCourse.getCourse().equals(course))
        return true;
      else
        currCourse = currCourse.getNextcourseNode();
    }
    return false;
  }

//Create index of course function
  @Override
  public int indexOfCourse(Course course) { // use CS index // return -1 or exception if course is not in list
    CourseNode currCourse = this.firstCourse;
    Integer x = ONE;
    while (currCourse != null) {
      if (currCourse.getCourse().equals(course))
        return x;
      else
        x++;
        currCourse = currCourse.getNextcourseNode();
    }
    return -ONE;
  }

//Create course get function
  @Override
  public Course get(Integer index) { // CS index
    CourseNode currCourse = this.firstCourse;
    Integer x = ONE;
    while (currCourse != null) {
      if (x == index) {
        return currCourse.getCourse();
      }
      else{
        currCourse=currCourse.getNextcourseNode();
        x++;
      }
    }
    return new Course("","",ZERO);
  }

//Create is empty function
  @Override
  public boolean isEmpty() {
    return (this.numCourses.equals(ZERO));
  }

//Create is count function
  @Override
  public int count() {
    return this.numCourses;
  }

}
