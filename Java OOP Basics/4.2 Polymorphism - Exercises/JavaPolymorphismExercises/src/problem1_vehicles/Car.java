package problem1_vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle{


    protected Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void refuel(Double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }

    @Override
    public void drive(Double distance) {
        if(this.getFuelQuantity() < (distance * this.getFuelConsumption())){
            throw new IllegalArgumentException("Car needs refueling");
        }
        System.out.printf("Car travelled %s km%n", new DecimalFormat("#.##").format(distance));
        this.setFuelQuantity(this.getFuelQuantity() - (distance * this.getFuelConsumption()));
    }
}
