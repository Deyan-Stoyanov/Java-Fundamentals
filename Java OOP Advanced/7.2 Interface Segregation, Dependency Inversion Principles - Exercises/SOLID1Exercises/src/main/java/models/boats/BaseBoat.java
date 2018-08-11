package models.boats;

import utility.Constants;
import utility.Validator;
import contracts.Modelable;
import contracts.Race;

public class BaseBoat implements Modelable {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return model;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_MODEL_LENGTH);
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    private void setWeight(int weight) {
        Validator.validatePropertyValue(weight, "Weight");
        this.weight = weight;
    }

    public double calculateRaceSpeed(Race race) {
        return 0;
    }
}
