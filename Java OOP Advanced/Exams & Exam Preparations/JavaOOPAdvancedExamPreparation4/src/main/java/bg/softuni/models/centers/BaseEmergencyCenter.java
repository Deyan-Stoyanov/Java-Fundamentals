package bg.softuni.models.centers;

import bg.softuni.abstractions.Emergency;
import bg.softuni.abstractions.EmergencyCenter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class BaseEmergencyCenter implements EmergencyCenter {
    private String name;

    private Integer amountOfMaximumEmergencies;

    private Set<Emergency> emergencies;

    protected BaseEmergencyCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.emergencies = new LinkedHashSet<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    public Boolean isForRetirement(){
        return this.emergencies.size() >= this.amountOfMaximumEmergencies;
    }

    @Override
    public Set<Emergency> getEmergencies() {
        return Collections.unmodifiableSet(this.emergencies);
    }

    public void setEmergencies(Set<Emergency> emergencies) {
        this.emergencies = emergencies;
    }

    @Override
    public void addEmergency(Emergency emergency){
        this.emergencies.add(emergency);
    }

    @Override
    public void removeEmergency(Emergency emergency){
        this.emergencies.remove(emergency);
    }
}
