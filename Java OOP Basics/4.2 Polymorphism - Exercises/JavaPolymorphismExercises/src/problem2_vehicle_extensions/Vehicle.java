package problem2_vehicle_extensions;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double tankCapacity;
    private Double fuelQuantity;
    private Double fuelConsumption;

    protected Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected Double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(Double fuelQuantity) {
        if(fuelQuantity < 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected Double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected abstract void refuel(Double fuel);

    protected void drive(Double distance) {
        if(this.getFuelQuantity() < (distance * this.getFuelConsumption())){
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }

    public Double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
