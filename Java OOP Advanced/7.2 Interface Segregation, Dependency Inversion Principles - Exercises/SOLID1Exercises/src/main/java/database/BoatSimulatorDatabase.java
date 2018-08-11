package database;

import contracts.Modelable;
import contracts.Repository;
import models.boats.BaseBoat;

public class BoatSimulatorDatabase {
    Repository<BaseBoat> boats;
    Repository<Modelable> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new RepositoryImpl());
        this.setEngines(new RepositoryImpl());
    }

    public Repository<BaseBoat> getBoats() {
        return this.boats;
    }

    private void setBoats(Repository<BaseBoat> boats) {
        this.boats = boats;
    }

    public Repository<Modelable> getEngines() {
        return this.engines;
    }

    private void setEngines(Repository<Modelable> engines) {
        this.engines = engines;
    }
}
