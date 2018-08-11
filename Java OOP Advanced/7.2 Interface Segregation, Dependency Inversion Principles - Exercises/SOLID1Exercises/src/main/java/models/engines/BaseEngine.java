package models.engines;

import utility.Constants;
import utility.Validator;
import contracts.Modelable;

public class BaseEngine implements Modelable {
    protected int cachedOutput;

    private String model;

    private int horsepower;

    private int displacement;

    public BaseEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    public int getOutput() {
        if (this.cachedOutput != 0) {
            return this.cachedOutput;
        }

        this.cachedOutput = (this.getHorsepower()) + this.getDisplacement();
        return this.cachedOutput;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getDisplacement() {
        return displacement;
    }

    protected void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    public void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }
}
