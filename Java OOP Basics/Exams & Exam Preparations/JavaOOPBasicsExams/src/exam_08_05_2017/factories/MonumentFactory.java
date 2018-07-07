package exam_08_05_2017.factories;

import exam_08_05_2017.entities.monuments.*;

public class MonumentFactory {

    public MonumentFactory() {
    }

    public Monument createMonument(String type, String name, int affinity) {
        switch (type) {
            case "Air":
                return new AirMonument(name, affinity);
            case "Fire":
                return new FireMonument(name, affinity);
            case "Earth":
                return new EarthMonument(name, affinity);
            case "Water":
                return new WaterMonument(name, affinity);
            default:
                return null;
        }
    }
}
