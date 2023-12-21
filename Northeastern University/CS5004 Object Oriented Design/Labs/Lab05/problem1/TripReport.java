package problem1;

import java.util.Objects;

public class TripReport {
  private Vehicle vehicleThatTookTheTrip;
  private Float speed;
  private Float distance;
  private Integer tripDuration;

  public TripReport(Vehicle vehicleThatTookTheTrip, Float speed, Float distance,
      Integer tripDuration) {
    this.vehicleThatTookTheTrip = vehicleThatTookTheTrip;
    this.speed = speed;
    this.distance = distance;
    this.tripDuration = tripDuration;
  }

  public Vehicle getVehicleThatTookTheTrip() {
    return vehicleThatTookTheTrip;
  }

  public void setVehicleThatTookTheTrip(Vehicle vehicleThatTookTheTrip) {
    this.vehicleThatTookTheTrip = vehicleThatTookTheTrip;
  }

  public Float getSpeed() {
    return speed;
  }

  public void setSpeed(Float speed) {
    this.speed = speed;
  }

  public Float getDistance() {
    return distance;
  }

  public void setDistance(Float distance) {
    this.distance = distance;
  }

  public Integer getTripDuration() {
    return tripDuration;
  }

  public void setTripDuration(Integer tripDuration) {
    this.tripDuration = tripDuration;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TripReport that = (TripReport) o;
    return Objects.equals(vehicleThatTookTheTrip, that.vehicleThatTookTheTrip)
        && Objects.equals(speed, that.speed) && Objects.equals(distance,
        that.distance) && Objects.equals(tripDuration, that.tripDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleThatTookTheTrip, speed, distance, tripDuration);
  }
}
