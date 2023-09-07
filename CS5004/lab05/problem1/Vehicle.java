package problem1;

public abstract class Vehicle {
  protected String ID;
  protected Float AvgSpeed;
  protected Float maxSpeed;

  public Vehicle(String id, Float avgSpeed, Float maxSpeed) {
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public Float getAvgSpeed() {
    return AvgSpeed;
  }

  public void setAvgSpeed(Float avgSpeed) {
    AvgSpeed = avgSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(Float maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}
