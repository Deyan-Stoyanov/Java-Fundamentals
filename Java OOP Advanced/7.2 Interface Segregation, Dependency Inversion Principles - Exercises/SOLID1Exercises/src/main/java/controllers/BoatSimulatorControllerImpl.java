package controllers;

import utility.Constants;
import contracts.BoatSimulatorController;
import contracts.Modelable;
import contracts.Race;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.boats.*;
import models.engines.BaseEngine;
import models.engines.JetEngine;
import models.RaceImpl;
import models.engines.SterndriveEngine;

import java.util.*;

public class BoatSimulatorControllerImpl implements BoatSimulatorController {
    private Map<Double, BaseBoat> map = new LinkedHashMap<>();
    private BoatSimulatorDatabase database;
    private Race currentRace;

    public BoatSimulatorControllerImpl(BoatSimulatorDatabase database, Race currentRace) {
        this.setDatabase(database);
        this.setCurrentRace(currentRace);
    }

    @Override
    public String createBoatEngine(String model, int horsepower, int displacement, String engineType) {
        try {
            return this.createBoatEngine(model, horsepower, displacement, Enum.valueOf(EngineType.class, engineType));
        } catch (DuplicateModelException e) {
            return e.getMessage();
        }
    }


    public void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    public void setCurrentRace(Race currentRace) {
        this.currentRace = currentRace;
    }

    public String createBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        Modelable engine = null;
        switch (engineType) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                break;
        }
        this.database.getEngines().add(engine);
        return String.format(
                "Engine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String createRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        BaseBoat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String createSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        BaseBoat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String createPowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BaseEngine firstEngine = (BaseEngine) this.database.getEngines().getItem(firstEngineModel);
        BaseEngine secondEngine = (BaseEngine) this.database.getEngines().getItem(secondEngineModel);
        BaseBoat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String createYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BaseEngine engine = (BaseEngine) this.database.getEngines().getItem(engineModel);
        BaseBoat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.getBoats().add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String openRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        Race race = new RaceImpl(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.validateRaceIsEmpty();
        this.currentRace = race;
        return String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set.", distance, windSpeed, oceanCurrentSpeed);
    }

    public String signUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        BaseBoat boat = this.database.getBoats().getItem(model);
        this.validateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && (boat instanceof PowerBoat || boat instanceof Yacht)) {
            throw new IllegalArgumentException(Constants.INCORRECT_BOAT_TYPE_MESSAGE);
        }
        this.currentRace.addParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String startRace() throws InsufficientContestantsException, NoSetRaceException {
        this.validateRaceIsSet();
        List<BaseBoat> participants = this.currentRace.getParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.INSUFFICIENT_CONTESTANTS_MESSAGE);
        }
        double e = 0.000000001;
        for (int i = 0; i < 3; i++) {
            findFastest(participants, e);
            e *= 2;
        }
        StringBuilder result = new StringBuilder();
        int i = 1;
        String place;
        for (Map.Entry<Double, BaseBoat> doubleMotorBoatEntry : map.entrySet()) {
            if(i == 1){
                place = "First";
            } else if(i == 2){
                place = "Second";
                result.append(System.lineSeparator());
            } else {
                place = "Third";
                result.append(System.lineSeparator());
            }
            result.append(String.format("%s place: %s Model: %s Time: %s",
                    place,
                    doubleMotorBoatEntry.getValue().getClass().getSimpleName(),
                    doubleMotorBoatEntry.getValue().getModel(),
                    isFinished(doubleMotorBoatEntry.getKey())));
            i++;
        }
        this.currentRace = null;
        return result.toString();
    }

    private String isFinished(Double key) {
        if (key <= 0) {
            return "Did not finish!";
        }
        return String.format("%.2f sec", key);
    }

    @Override
    public String getStatistic() {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> stats = new HashMap<>();
        for (BaseBoat baseBoat : currentRace.getParticipants()) {
            if(!stats.containsKey(baseBoat.getClass().getSimpleName())){
                stats.put(baseBoat.getClass().getSimpleName(), 0);
            }
            stats.put(baseBoat.getClass().getSimpleName(), stats.get(baseBoat.getClass().getSimpleName()) + 1);
        }
        stats.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(x -> sb.append(x.getKey()).append(" -> ").append(String.format("%.2f", (x.getValue() * 100d) / currentRace.getParticipants().size())).append("%").append(System.lineSeparator()));
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private void findFastest(List<BaseBoat> participants, double e) {
        Double bestTime = Double.MAX_VALUE;
        BaseBoat winner = null;
        for (BaseBoat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if (time < bestTime && time > 0) {
                bestTime = time;
                winner = participant;
            }
        }
        if(winner == null){
            winner = participants.get(0);
            bestTime = this.currentRace.getDistance() / winner.calculateRaceSpeed(this.currentRace);
        }
        map.put(bestTime + e, winner);
        participants.remove(winner);
    }

    private void validateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NO_SET_RACE_MESSAGE);
        }
    }

    private void validateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RACE_ALREADY_EXISTS_MESSAGE);
        }
    }
}
