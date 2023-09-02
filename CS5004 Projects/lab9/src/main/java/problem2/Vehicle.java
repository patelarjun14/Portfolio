package problem2;

import java.util.Objects;

public class Vehicle {
  private String make;
  private String model;
  private Integer year;
  private Color vehicleColor;

  public Vehicle(String make, String model, Integer year, Color vehicleColor) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.vehicleColor = vehicleColor;
  }


  public String getMake() {
    return this.make;
  }

  public String getModel() {
    return this.model;
  }


  public Integer getYear() {
    return this.year;
  }


  public Color getVehicleColor() {
    return this.vehicleColor;
  }


  protected  static void printMakeModelAndYear(Vehicle vehicle) {
    System.out.println(
        "Make ='" + vehicle.getMake() + "'" +
        ", Model='" + vehicle.getModel() + "'" +
        ", Year=" +vehicle.getYear());
  }

  protected Boolean isYoungerThanGiveYear(Integer year){
    return this.getYear() > year;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(make, vehicle.make) && Objects.equals(model,
        vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(
        vehicleColor, vehicle.vehicleColor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, vehicleColor);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", vehicleColor=" + vehicleColor +
        '}';
  }
}
