package models.boats;

import utility.Validator;
import contracts.Race;

public class RowBoat extends BaseBoat{
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        this.setOars(oars);
    }

    public int getOars() {
        return this.oars;
    }

    private void setOars(int oars) {
        Validator.validatePropertyValue(oars, "Oars");
        this.oars = oars;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (this.getOars() * 100) - this.getWeight() + race.getOceanCurrentSpeed();
    }
}
