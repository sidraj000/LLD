import java.util.ArrayList;

public class ParkingLot{
 
public enum VehicleSize
{
  Motorcycle,Compact,Large;
// An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).
// An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).
}
public class ParkingSpot {
  private Vehicle vehicle;
  private VehicleSize spotSize;
  private int row;
  
  private int spotNumber;
  private Level level;
  public ParkingSpot(Level Ivl, int r, int n, VehicleSize s) 
  {
    //constructor
  }
  public boolean isAvailable() { return vehicle == null; }
  
   /* Check if the spot is big enough and is available */
  public boolean canFitVehicle(Vehicle vehicle) { return true;}
  
  /* Park vehicle in this spot. */
  public boolean park(Vehicle v) { return true; }
  
  public int getRow() { return row; }
  public int getSpotNumber() { return spotNumber; }
  
  /* Remove vehicle from spot, and notify level that a new spot is
   * available */
  public void removeVehicle() { return; }
}
/* Represents a level in a parking garage */
public class Level {
   private int floor;
   private ParkingSpot[ ] spots;
   private int availableSpots = 0; // number of free spots
   private static final int SPOTS_PER_ROW = 10;
  
   public Level(int flr, int numberSpots) { 
     //constructor;
   }
  
   public int availableSpots() { return availableSpots; }
  
   /* Find a place to park this vehicle. Return false if failed. */
   public boolean parkVehicle(Vehicle vehicle) { return true; }
  
   /* Park a vehicle starting at the spot spotNumber, and
   * continuing until vehicle.spotsNeeded. */
   private boolean parkStartingAtSpot(int num, Vehicle v) { return true; }
   /* Find a spot to park this vehicle. Return index of spot, or -1
   * on failure. */
   private int findAvailableSpots(Vehicle vehicle) { return 0; }
  
   /* When a car was removed from the spot, increment
   * availableSpots */
   public void spotFreed() { availableSpots++; }
}
public class ParkingLot {
  private Level[ ] levels;
  private final int NUM_LEVELS = 5;
  public ParkingLot() { ; }
  /* Park the vehicle in a spot (or multiple spots).
   * Return false if failed. */
  public boolean parkVehicle(Vehicle vehicle) { return true; }
}
public abstract class Vehicle{
  protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
  protected String licensePlate;
  protected Integer spotsNeeded;
  protected VehicleSize size;
  public int getSpotsNeeded()
  {
    return spotsNeeded;
  }
  public void clearSpots()
  {

  }
  public abstract boolean canFitInSpot(ParkingSpot spot);
}
public class Bus extends Vehicle {
public Bus() {
  spotsNeeded = 5;
  size = VehicleSize.Large;
  }
  
   /* Checks if the spot is a Large. Doesn't check num of spots */
   public boolean canFitInSpot(ParkingSpot spot) { return true; }
}
  
public class Car extends Vehicle {
   public Car() {
   spotsNeeded = 1;
   size = VehicleSize.Compact;
 }
   /* Checks if the spot is a Compact or a Large. */
   public boolean canFitlnSpot(ParkingSpot spot) { return true; }
}
  
  public class Motorcycle extends Vehicle {
   public Motorcycle() {
   spotsNeeded = 1;
   size = VehicleSize.Motorcycle;
   }
  
   public boolean canFitInSpot(ParkingSpot spot) {return true;}
}

public static void main(String[] args) {
  
}
}