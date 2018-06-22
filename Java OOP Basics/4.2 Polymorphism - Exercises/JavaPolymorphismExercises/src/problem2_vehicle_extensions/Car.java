package problem2_vehicle_extensions;


public class Car extends Vehicle {

    protected Car(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public void refuel(Double fuel) {
        if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if ((fuel + this.getFuelQuantity()) > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(super.getFuelQuantity() + fuel);
    }
}
