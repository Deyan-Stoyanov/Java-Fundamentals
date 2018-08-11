package models.boats;

import contracts.Race;
import models.engines.BaseEngine;

public class PowerBoat extends BaseBoat {
    private BaseEngine firstEngine;
    private BaseEngine secondEngine;

    public PowerBoat(String model, int weight, BaseEngine firstEngine, BaseEngine secondEngine) {
        super(model, weight);
        this.firstEngine = firstEngine;
        this.secondEngine = secondEngine;
    }

    public BaseEngine getFirstEngine() {
        return this.firstEngine;
    }

    public void setFirstEngine(BaseEngine firstEngine) {
        this.firstEngine = firstEngine;
    }

    public BaseEngine getSecondEngine() {
        return this.secondEngine;
    }

    public void setSecondEngine(BaseEngine secondEngine) {
        this.secondEngine = secondEngine;
    }

    @Override
    public double calculateRaceSpeed(Race race) {
        return this.getFirstEngine().getOutput() + this.getSecondEngine().getOutput() - this.getWeight() + (race.getOceanCurrentSpeed() / 5d);
    }
}
