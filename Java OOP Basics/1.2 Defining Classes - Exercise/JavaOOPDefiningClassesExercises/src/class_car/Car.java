package class_car;

public class Car {
    private String model;
    private double fuelAmount;
    private double distanceTravelled;
    private double fuelCostForOneKilometer;

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.distanceTravelled = 0;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public double getFuelCostForOneKilometer() {
        return fuelCostForOneKilometer;
    }

    public void setFuelCostForOneKilometer(double fuelCostForOneKilometer) {
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
    }

    public void drive(double kilometers){
        if(kilometers * this.fuelCostForOneKilometer <= fuelAmount){
            this.setDistanceTravelled(this.getDistanceTravelled() + kilometers);
            this.setFuelAmount(this.getFuelAmount() - (this.getFuelCostForOneKilometer() * kilometers));
        } else {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
    }
}
