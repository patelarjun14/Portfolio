package problem1;

public class FleetManager {
  public TripReport drive(float distance, Vehicle vehicle){
    Integer tripDuration = 0;
    if(vehicle.getAvgSpeed() >0)
      tripDuration = Math.round(distance/ vehicle.getAvgSpeed());
    return new TripReport(vehicle, vehicle.getAvgSpeed(),distance, tripDuration);
  }

  public TripReport driv(float distance, float avgSpeed, Vehicle vehicle)
      throws IllegalAccessException {
    Integer tripDuration = 0;
    if (avgSpeed > 0 && avgSpeed <= vehicle.AvgSpeed) {
      tripDuration = Math.round(distance / avgSpeed);
      return new TripReport(vehicle, vehicle.getAvgSpeed(), distance, tripDuration);
    }
    else throw new IllegalAccessException("Provided average speed is invalid");
  }

  public TripReport drive(float distance, Vehicle vehicle, float speed, int duration)
      throws IllegalAccessException {
    if(distance > 0 && speed >0 && speed <= vehicle.getMaxSpeed() && duration >= 0)
      return new TripReport(vehicle, speed, distance, duration);
    else throw new IllegalAccessException("The trip information is not correct");
  }
  public TripReport drive(Vehicle vehicle, int duration) {
    float distance =0;
    if(duration >= 0)
      distance = duration* vehicle.getAvgSpeed();
    return new TripReport(vehicle, vehicle.getAvgSpeed(),distance,duration);
  }


}
