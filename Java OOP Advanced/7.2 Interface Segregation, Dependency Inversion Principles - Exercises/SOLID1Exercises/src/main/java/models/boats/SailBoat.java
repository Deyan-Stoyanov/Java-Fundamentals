package models.boats;

import utility.Constants;
import contracts.Race;

public class SailBoat extends BaseBoat{
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        this.sailEfficiency = sailEfficiency;
    }

    public int getSailEfficiency() {
        return this.sailEfficiency;
    }

    private void setSailEfficiency(int sailEfficiency) {
        if(sailEfficiency <= 0 || sailEfficiency > 100){
            throw new IllegalArgumentException(Constants.INCORRECT_SAIL_EFFICIENCY_MESSAGE);
        }
        this.sailEfficiency = sailEfficiency;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return (race.getWindSpeed() * (this.getSailEfficiency() / 100d)) - this.getWeight() + (race.getOceanCurrentSpeed() / 2d);
    }
}
