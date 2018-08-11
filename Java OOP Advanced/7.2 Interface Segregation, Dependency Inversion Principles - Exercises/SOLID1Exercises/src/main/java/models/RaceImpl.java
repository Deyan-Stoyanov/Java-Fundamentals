package models;

import utility.Constants;
import utility.Validator;
import contracts.Race;
import exeptions.DuplicateModelException;
import models.boats.BaseBoat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oseanCurrentSpeed;
    private boolean allowsMotorBoats;
    private Map<String, BaseBoat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOseanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsMotorBoats(allowsMotorBoats);
        this.registeredBoats = new HashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oseanCurrentSpeed;
    }

    private void setOseanCurrentSpeed(int oseanCurrentSpeed) {
        this.oseanCurrentSpeed = oseanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsMotorBoats;
    }

    private void setAllowsMotorBoats(boolean allowsMotorBoats) {
        this.allowsMotorBoats = allowsMotorBoats;
    }

    protected Map<String, BaseBoat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    public void addParticipant(BaseBoat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<BaseBoat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}