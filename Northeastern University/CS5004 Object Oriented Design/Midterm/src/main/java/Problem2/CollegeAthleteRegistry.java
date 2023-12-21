package Problem2;

public class CollegeAthleteRegistry implements ICollegeAthleteRegistry{
  private Integer numCollegeAthletes;
  private CollegeAthleteNode firstCollegeAthlete;

  public CollegeAthleteRegistry(Integer numCollegeAthletes,
      CollegeAthleteNode firstCollegeAthlete) {
    this.numCollegeAthletes = numCollegeAthletes;
    this.firstCollegeAthlete = firstCollegeAthlete;
  }


  @Override
  public int count() {
    return this.numCollegeAthletes;
  }

  @Override
  public boolean contains(CollegeAthlete athlete) {
    CollegeAthleteNode currNode = this.firstCollegeAthlete;
    while(currNode != null){
      if(currNode.getCollegeAthlete().equals(athlete)) {
        return true;
      }
      else {
        currNode = currNode.getNextCollegeAthleteNode();
      }
    }
    return false;
  }

  @Override
  public void add(CollegeAthlete athlete) {
    if(this.contains(athlete)){
      return;
    }
    else {
      CollegeAthleteNode newAthlete = new CollegeAthleteNode(athlete, this.firstCollegeAthlete);
      this.firstCollegeAthlete = newAthlete;
      this.numCollegeAthletes++;
    }
  }

  @Override
  public void modify(CollegeAthlete athlete, CollegeAthlete newInformation)
      throws CollegeAthleteNotFoundException {
    CollegeAthleteNode currNode = this.firstCollegeAthlete;
    if(this.contains(athlete)) {
      while (currNode != null) {
        if (currNode.getCollegeAthlete().equals(athlete)) {
          currNode.setCollegeAthlete(newInformation);
        } else {
          currNode = currNode.getNextCollegeAthleteNode();
        }
      }
    }
    else{
        throw new CollegeAthleteNotFoundException("College athlete not found");
      }
  }


  @Override
  public void remove(CollegeAthlete athlete) throws CollegeAthleteNotFoundException{
    if (this.contains(athlete)) {
      CollegeAthleteNode currNode = this.firstCollegeAthlete;
      CollegeAthleteNode prevNode = null;
      while (!currNode.getCollegeAthlete().equals(athlete)) {
        prevNode = currNode;
        currNode = currNode.getNextCollegeAthleteNode();
      }
      if (prevNode == null) {
        this.firstCollegeAthlete = this.firstCollegeAthlete.getNextCollegeAthleteNode();
        this.numCollegeAthletes--;
      } else {
        prevNode.setNextCollegeAthleteNode(currNode.getNextCollegeAthleteNode());
        this.numCollegeAthletes--;

      }
    }
    else {
      throw new CollegeAthleteNotFoundException("This athlete cannot be found");
    }
  }

  @Override
  public CollegeAthlete disciplineReturn(String discipline) {
    CollegeAthleteNode currNode = this.firstCollegeAthlete;
    while(currNode != null) {
      if(currNode.getCollegeAthlete().getDiscipline() == discipline) {
        return currNode.getCollegeAthlete();
      }
      else{
        currNode = currNode.getNextCollegeAthleteNode();
      }
    }
    return null;
  }

  @Override
  public CollegeAthleteRegistry earningsReturn(Double amount) {
    CollegeAthleteNode currNode = this.firstCollegeAthlete;
    CollegeAthleteRegistry newList = new CollegeAthleteRegistry(0,null);
    while(currNode != null) {
      if(currNode.getCollegeAthlete().getTotalEarningsThusFar() > amount) {
        newList.add(currNode.getCollegeAthlete());
      }
      else{
        currNode = currNode.getNextCollegeAthleteNode();
      }
    }
    return newList;
  }

  @Override
  public CollegeAthleteRegistry collegeReturn(String college) {
    CollegeAthleteNode currNode = this.firstCollegeAthlete;
    CollegeAthleteRegistry newList = new CollegeAthleteRegistry(0,null);
    while(currNode != null) {
      if(currNode.getCollegeAthlete().getCollege() == college) {
        newList.add(currNode.getCollegeAthlete());
      }
      else{
        currNode = currNode.getNextCollegeAthleteNode();
      }
    }
    return newList;

  }
}
