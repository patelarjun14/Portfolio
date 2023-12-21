package p2;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentIterator implements Iterator {
  private List<Student> studentListAllFour;

  public StudentIterator(List<Student> studentList) {
    this.studentListAllFour = this.getStudentList(studentList);
  }


  public List<Student> getStudentListAllFour() {
    return this.studentListAllFour;
  }

  public void setStudentListAllFour(List<Student> studentListAllFour) {
    this.studentListAllFour = studentListAllFour;
  }



  private List<Student> getStudentList(List<Student> studentList) {
    return studentList.stream().filter(x -> x.alignFourClasses()).collect(Collectors.toList());
  }


  @Override
  public boolean hasNext(){
    return studentListAllFour.size()>0;
  }

  @Override
  public Object next(){
    return studentListAllFour.remove(0);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StudentIterator that = (StudentIterator) o;
    return Objects.equals(studentListAllFour, that.studentListAllFour);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentListAllFour);
  }


  @Override
  public String toString() {
    return "StudentIterator{" +
        "studentListAllFour=" + studentListAllFour +
        '}';
  }

}
