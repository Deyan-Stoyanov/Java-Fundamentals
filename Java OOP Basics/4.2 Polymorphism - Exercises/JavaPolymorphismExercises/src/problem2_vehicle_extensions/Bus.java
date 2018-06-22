package problem2_vehicle_extensions;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    protected Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void refuel(Double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if ((fuel + this.getFuelQuantity()) > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }

    @Override
    protected void drive(Double distance) {
        if (this.getFuelQuantity() < (distance * (this.getFuelConsumption() + 1.4))) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), new DecimalFormat("#.##").format(distance));
        this.setFuelQuantity(this.getFuelQuantity() - (distance * (this.getFuelConsumption() + 1.4)));
    }

    public void driveEmpty(Double distance) {
        super.drive(distance);
    }
}
