package Problem2;

import java.util.ArrayList;
import java.util.Objects;

abstract class Group extends Creators {
  public ArrayList<RecordingArtist> people;

  public Group(ArrayList<RecordingArtist> people) {
    this.people = people;
  }

  public ArrayList<RecordingArtist> getPeople() {
    return people;
  }

  public void setPeople(ArrayList<RecordingArtist> people) {
    this.people = people;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(people, group.people);
  }

  @Override
  public int hashCode() {
    return Objects.hash(people);
  }

  @Override
  public String toString() {
    return "Group{" +
        "people=" + people +
        '}';
  }
}
