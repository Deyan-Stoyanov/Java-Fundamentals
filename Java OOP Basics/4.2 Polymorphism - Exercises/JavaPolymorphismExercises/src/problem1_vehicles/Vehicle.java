package problem1_vehicles;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumption;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected Double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected Double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public abstract void refuel(Double fuel);
    public abstract void drive(Double distance);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

}
