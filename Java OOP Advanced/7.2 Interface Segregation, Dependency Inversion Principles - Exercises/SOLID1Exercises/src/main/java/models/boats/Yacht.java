package models.boats;

import utility.Validator;
import contracts.Race;
import models.engines.BaseEngine;

public class Yacht extends BaseBoat {
    private BaseEngine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, BaseEngine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        this.cargoWeight = cargoWeight;
    }

    public BaseEngine getEngine() {
        return this.engine;
    }

    public void setEngine(BaseEngine engine) {
        this.engine = engine;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        Validator.validatePropertyValue(cargoWeight, "Cargo Weight");
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.engine.getOutput()- this.getWeight() - this.getCargoWeight() + (race.getOceanCurrentSpeed() / 2d);
    }
}
