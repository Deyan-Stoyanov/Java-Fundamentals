package raw_data;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Set<Tire> tires;

    public Car() {
    }

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double firstTirePressure, int firstTireAge, double secondTirePressure, int secondTireAge, double thirdTirePressure, int thirdTireAge, double fourthTirePressure, int fourthTireAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        Tire[] t = new Tire[]{new Tire(firstTirePressure, firstTireAge), new Tire(secondTirePressure, secondTireAge), new Tire(thirdTirePressure, thirdTireAge), new Tire(fourthTirePressure, fourthTireAge)};
        this.tires = Arrays.stream(t).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Set<Tire> getTires() {
        return tires;
    }

    public void setTires(Set<Tire> tires) {
        this.tires = tires;
    }
}
