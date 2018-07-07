package exam_08_05_2017;

import exam_08_05_2017.entities.benders.Bender;
import exam_08_05_2017.entities.monuments.Monument;
import exam_08_05_2017.entities.nations.Nation;
import exam_08_05_2017.factories.BenderFactory;
import exam_08_05_2017.factories.MonumentFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AvatarManager {
    private Nation fireNation;
    private Nation airNation;
    private Nation waterNation;
    private Nation earthNation;

    private BenderFactory benderFactory;
    private MonumentFactory monumentFactory;

    private Map<Integer, String> wars;
    private int warNumber;

    public AvatarManager() {
        this.fireNation = new Nation("Fire");
        this.airNation = new Nation("Air");
        this.earthNation = new Nation("Earth");
        this.waterNation = new Nation("Water");
        this.monumentFactory = new MonumentFactory();
        this.benderFactory = new BenderFactory();
        this.wars = new LinkedHashMap<>();
        warNumber = 0;
    }

    public Nation getFireNation() {
        return fireNation;
    }

    public Nation getAirNation() {
        return airNation;
    }

    public Nation getWaterNation() {
        return waterNation;
    }

    public Nation getEarthNation() {
        return earthNation;
    }

    public Map<Integer, String> getWars() {
        return wars;
    }

    public void addBender(String type, String name, int power, double secondaryParameter) {
        Bender bender = this.benderFactory.createBender(type, name, power, secondaryParameter);
        if (bender != null) {
            switch (type) {
                case "Water":
                    this.waterNation.addBender(bender);
                    break;
                case "Air":
                    this.airNation.addBender(bender);
                    break;
                case "Fire":
                    this.fireNation.addBender(bender);
                    break;
                case "Earth":
                    this.earthNation.addBender(bender);
                    break;
                default:
                    break;
            }
        }
    }

    public void addMonument(String type, String name, int affinity) {
        Monument monument = this.monumentFactory.createMonument(type, name, affinity);
        if (monument != null) {
            switch (type) {
                case "Air":
                    this.airNation.addMonument(monument);
                    break;
                case "Earth":
                    this.earthNation.addMonument(monument);
                    break;
                case "Fire":
                    this.fireNation.addMonument(monument);
                    break;
                case "Water":
                    this.waterNation.addMonument(monument);
                    break;
                default:
                    break;
            }
        }
    }

    public String status(String name) {
        switch (name) {
            case "Water":
                return this.waterNation.toString();
            case "Air":
                return this.airNation.toString();
            case "Earth":
                return this.earthNation.toString();
            case "Fire":
                return this.fireNation.toString();
            default:
                return null;
        }
    }

    public void war(String name) {
        this.wars.put(++this.warNumber, name);
        List<Nation> allNations = new ArrayList<>() {{
            add(getAirNation());
            add(getFireNation());
            add(getEarthNation());
            add(getWaterNation());
        }};
        String winner = allNations.stream().sorted((x, y) -> Double.compare(y.getTotalNationPower(), x.getTotalNationPower())).findFirst().get().getType();
        allNations.stream().filter(x -> !x.getType().equals(winner)).forEach(Nation::erase);
    }
}


