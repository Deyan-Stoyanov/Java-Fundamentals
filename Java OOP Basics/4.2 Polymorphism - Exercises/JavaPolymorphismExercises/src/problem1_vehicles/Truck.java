package problem1_vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    protected Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void refuel(Double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + (0.95 * fuel));
    }

    @Override
    public void drive(Double distance) {
        if(this.getFuelQuantity() < (distance * this.getFuelConsumption())){
            throw new IllegalArgumentException("Truck needs refueling");
        }
        System.out.printf("Truck travelled %s km%n", new DecimalFormat("#.##").format(distance));
        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()));
    }
}
