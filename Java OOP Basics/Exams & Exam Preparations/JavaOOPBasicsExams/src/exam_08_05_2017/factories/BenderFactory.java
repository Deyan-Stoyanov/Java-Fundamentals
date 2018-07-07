package exam_08_05_2017.factories;

import exam_08_05_2017.entities.benders.*;

public class BenderFactory {

    public BenderFactory() {
    }

    public Bender createBender(String type, String name, int power, double secondaryParameter) {
        switch (type) {
            case "Water":
                return new WaterBender(name, power, secondaryParameter);
            case "Earth":
                return new EarthBender(name, power, secondaryParameter);
            case "Air":
                return new AirBender(name, power, secondaryParameter);
            case "Fire":
                return new FireBender(name, power, secondaryParameter);
            default:
                return null;
        }
    }
}
