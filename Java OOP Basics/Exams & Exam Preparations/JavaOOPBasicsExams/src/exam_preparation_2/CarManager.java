package exam_preparation_2;

import exam_preparation_2.entities.cars.Car;
import exam_preparation_2.entities.cars.PerformanceCar;
import exam_preparation_2.entities.cars.ShowCar;
import exam_preparation_2.entities.garage.Garage;
import exam_preparation_2.entities.races.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarManager {
    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage = new Garage();

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case "Performance":
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case "Show":
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            default:
                break;
        }
        if (car != null) {
            cars.putIfAbsent(id, car);
        }
    }

    public String check(int id) {
        return this.cars.get(id).toString();
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
            default:
                break;
        }
        races.putIfAbsent(id, race);
    }


    public void open(int id, String type, int length, String route, int prizePool, int additionalParam) {
        Race race = null;
        switch (type) {
            case "Circuit":
                race = new CircuitRace(length, route, prizePool, additionalParam);
                break;
            case "TimeLimit":
                race = new TimeLimitRace(length, route, prizePool, additionalParam);
                break;
            default:
                break;
        }
        races.putIfAbsent(id, race);
    }

    public void participate(int carId, int raceId) {
        if (!garage.getParkedCars().contains(this.cars.get(carId))) {
            this.races.get(raceId).addParticipant(this.cars.get(carId));
        }
    }

    public String start(int id) {
        Race race = races.get(id);
        if (race.getParticipants().isEmpty()) {
            return "Cannot start the race with zero participants.";
        }
        int prize = (50 * race.getPrizePool()) / 100;
        List<Car> topCars = new ArrayList<>();
        if (race instanceof CasualRace) {
            race.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getOverallPerformance(), x.getOverallPerformance())).limit(3).forEach(topCars::add);
        } else if (race instanceof DragRace) {
            race.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getEnginePerformance(), x.getEnginePerformance())).limit(3).forEach(topCars::add);
        } else if (race instanceof DriftRace) {
            race.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getSuspensionPerformance(), x.getSuspensionPerformance())).limit(3).forEach(topCars::add);
        } else if (race instanceof TimeLimitRace) {
            race.getParticipants().stream().limit(1).forEach(topCars::add);
        } else if (race instanceof CircuitRace) {
            race.getParticipants().forEach(x -> x.decreaseDurability(race.getLength(), ((CircuitRace) race).getLaps()));
            race.getParticipants().stream().sorted((x, y) -> Integer.compare(y.getOverallPerformance(), x.getOverallPerformance())).limit(4).forEach(topCars::add);
        }
        StringBuilder sb = new StringBuilder();
        if (race instanceof TimeLimitRace) {
            sb.append(String.format("%s - %d%n%s %s - %d s.%n%s Time, $%d.", race.getRoute(), race.getLength(), topCars.get(0).getBrand(), topCars.get(0).getModel(), topCars.get(0).getTimePerformance(race.getLength()), ((TimeLimitRace) race).getEarnedTime(), ((TimeLimitRace) race).getPrize()));
        } else {
            if (race instanceof CircuitRace) {
                sb.append(String.format("%s - %d", race.getRoute(), race.getLength() * ((CircuitRace) race).getLaps()));
            } else {
                sb.append(String.format("%s - %d", race.getRoute(), race.getLength()));
            }
            for (int i = 0; i < topCars.size(); i++) {
                if (i == 0 && race.getClass().getSimpleName().equals("CircuitRace")) {
                    prize = (40 * race.getPrizePool()) / 100;
                } else if (i == 1) {
                    prize = (30 * race.getPrizePool()) / 100;
                } else if (i == 2) {
                    prize = (20 * race.getPrizePool()) / 100;
                } else {
                    if (i == 3) {
                        if (race.getClass().getSimpleName().equals("CircuitRace")) {
                            prize = (10 * race.getPrizePool()) / 100;
                        } else {
                            break;
                        }
                    }
                }
                sb.append(String.format("%n%d. %s %s %dPP - $%d", i + 1, topCars.get(i).getBrand(), topCars.get(i).getModel(), topCars.get(i).getPerformancePoints(race.getClass().getSimpleName()), prize));
            }
        }
        races.remove(id);
        return sb.toString();
    }

    public void park(int id) {
        if (this.races.values().stream().noneMatch(x -> x.getParticipants().contains(this.cars.get(id)))) {
            this.garage.parkCar(this.cars.get(id));
        }
    }

    public void unpark(int id) {
        this.garage.unparkCar(this.cars.get(id));
    }

    public void tune(int tuneIndex, String addOn) {
        for (Car car : garage.getParkedCars()) {
            car.tune(tuneIndex, addOn);
        }
    }
}
