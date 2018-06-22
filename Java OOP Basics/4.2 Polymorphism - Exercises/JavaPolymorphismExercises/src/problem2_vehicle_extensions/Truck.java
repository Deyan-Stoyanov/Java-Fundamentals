package problem2_vehicle_extensions;


public class Truck extends Vehicle {

    protected Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(Double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 1.6);
    }

    @Override
    public void refuel(Double fuel) {
        if(fuel <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else if(((0.95 * fuel) + this.getFuelQuantity()) > this.getTankCapacity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(super.getFuelQuantity() + (0.95 * fuel));
    }
}
