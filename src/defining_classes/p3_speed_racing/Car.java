package defining_classes.p3_speed_racing;

public class Car {
    // information Model,
    // fuel amount,
    // fuel cost for 1 kilometer,
    // and distance traveled.

    private String model;
    private double fuelAmount;
    private double fuelCostPerKilometer;
    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKilometer = fuelCostPerKilometer;
        this.traveledDistance = 0;
    }

    // check whether the car can travel the distance
    public boolean hasSufficientFuel(double kilometers) {
        return this.fuelAmount >= calculateNeededFuel(kilometers);
    }

    // decrease the fuel
    public void decreaseFuel(int kilometers) {
        this.fuelAmount -= calculateNeededFuel(kilometers);
    }

    // increase traveledDistance
    public void increaseTravelDistance(int kilometers) {
        this.traveledDistance += kilometers;
    }

    @Override
    public String toString() {
        // "{Model} {fuelAmount} {distanceTraveled}",
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.traveledDistance);
    }

    private double calculateNeededFuel(double kilometers) {
        return this.fuelCostPerKilometer * kilometers;
    }
}
