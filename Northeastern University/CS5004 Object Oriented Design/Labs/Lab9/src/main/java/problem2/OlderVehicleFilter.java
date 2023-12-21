package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehicleFilter {
  private static Integer Filter_Year = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();


  public OlderVehicleFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehicleFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

  public void filterOlderVehicle_partialFunctionaCode(){
    List<Vehicle> youngerVehicles = new ArrayList<>();
    youngerVehicles = vehicles.stream().filter(x -> x.isYoungerThanGiveYear(Filter_Year)).collect(
        Collectors.toList());
    for(Vehicle vehicle: youngerVehicles){
      System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " "+ vehicle.getYear().toString());
    }
//    System.out.println(vehicles.stream().filter(x -> x.isYoungerThanGiveYear(1999))
//        .map(x-> "Vehicle: " + x.getMake() + " " + x.getModel() + " " + x.getYear()).collect(
//            Collectors.joining("; ")));
  }

  public void filterOlderVehicle_filteringAndMapping(){
    System.out.println(vehicles.stream()
                              .filter(x -> x.isYoungerThanGiveYear(Filter_Year))
                              .map(x -> x.getMake() + " " + x.getModel() + " " + x.getYear().toString())
                              .collect(Collectors.toList()));
  }


  public void filterOlderVehicle_helperMethod(){
    vehicles.stream()
        .filter(x -> x.isYoungerThanGiveYear(Filter_Year))
        .forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));
  }

  public void filterOlderVehicle(){
        System.out.println(vehicles.stream().filter(x -> x.isYoungerThanGiveYear(1999))
        .map(x-> "Vehicle: " + x.getMake() + " " + x.getModel() + " " + x.getYear()).collect(
            Collectors.joining("; ")));
  }

  public void filterOlderVehicles(){
    this.vehicles.stream().filter(vehicles -> vehicles.getYear() > Filter_Year).
        forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));

    List<Vehicle> resultingVehicles = this.vehicles.stream().filter(vehicle -> vehicle.getYear() > Filter_Year)
        .collect(Collectors.toList());
    resultingVehicles.stream().forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));
  }

  public List<Vehicle> filterOlderVehicles2(){
    List<Vehicle> resultingVehicles = this.vehicles.stream().filter(vehicle -> vehicle.isYoungerThanGiveYear(Filter_Year))
        .collect(Collectors.toList());
    resultingVehicles.stream().forEach(vehicle -> Vehicle.printMakeModelAndYear(vehicle));

    return resultingVehicles;
  }

}
