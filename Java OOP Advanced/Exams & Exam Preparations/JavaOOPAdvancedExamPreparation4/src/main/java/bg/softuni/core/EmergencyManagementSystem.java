package bg.softuni.core;

import bg.softuni.abstractions.Emergency;
import bg.softuni.abstractions.EmergencyCenter;
import bg.softuni.abstractions.ManagementSystem;
import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.centers.FiremanServiceCenter;
import bg.softuni.models.centers.MedicalServiceCenter;
import bg.softuni.models.centers.PoliceServiceCenter;
import bg.softuni.models.emergencies.PublicHealthEmergency;
import bg.softuni.models.emergencies.PublicOrderEmergency;
import bg.softuni.models.emergencies.PublicPropertyEmergency;
import bg.softuni.utils.RegistrationTime;

import java.util.*;

public class EmergencyManagementSystem implements ManagementSystem {

    private String[] input;
    private LinkedList<Emergency> emergencies;
    private LinkedList<EmergencyCenter> centers;
    private List<EmergencyCenter> retiredCenters;

    public EmergencyManagementSystem() {
        this.emergencies = new LinkedList<>();
        this.centers = new LinkedList<>();
        this.retiredCenters = new ArrayList<>();
    }

    @Override
    public String registerPropertyEmergency() {
        PublicPropertyEmergency emergency =  new PublicPropertyEmergency(this.input[1], Enum.valueOf(EmergencyLevel.class, this.input[2]), new RegistrationTime(this.input[3]), Integer.parseInt(input[4]));
        this.emergencies.add(emergency);
        return String.format("Registered Public Property Emergency of level %s at %s.", emergency.getEmergencyLevel().name(), emergency.getRegistrationTime().toString());
    }

    @Override
    public String registerHealthEmergency() {
        PublicHealthEmergency emergency =  new PublicHealthEmergency(this.input[1], Enum.valueOf(EmergencyLevel.class, this.input[2]), new RegistrationTime(this.input[3]), Integer.parseInt(input[4]));
        this.emergencies.add(emergency);
        return String.format("Registered Public Health Emergency of level %s at %s.", emergency.getEmergencyLevel().name(), emergency.getRegistrationTime().toString());
    }

    @Override
    public String registerOrderEmergency() {
        PublicOrderEmergency emergency =  new PublicOrderEmergency(this.input[1], Enum.valueOf(EmergencyLevel.class, this.input[2]), new RegistrationTime(this.input[3]), input[4].equalsIgnoreCase("Special"));
        this.emergencies.add(emergency);
        return String.format("Registered Public Order Emergency of level %s at %s.", emergency.getEmergencyLevel().name(), emergency.getRegistrationTime().toString());
    }

    @Override
    public String registerFireServiceCenter() {
        FiremanServiceCenter center = new FiremanServiceCenter(this.input[1], Integer.parseInt(this.input[2]));
        this.centers.add(center);
        return String.format("Registered Fire Service Emergency Center - %s.", center.getName());
    }

    @Override
    public String registerMedicalServiceCenter() {
        MedicalServiceCenter center = new MedicalServiceCenter(this.input[1], Integer.parseInt(this.input[2]));
        this.centers.add(center);
        return String.format("Registered Medical Service Emergency Center - %s.", center.getName());
    }

    @Override
    public String registerPoliceServiceCenter() {
        PoliceServiceCenter center = new PoliceServiceCenter(this.input[1], Integer.parseInt(this.input[2]));
        this.centers.add(center);
        return String.format("Registered Police Service Emergency Center - %s.", center.getName());
    }

    @Override
    public String processEmergencies() {
        String type = this.input[1];
        for (int i = 0; i < this.emergencies.size(); i++) {
            Emergency emergency = this.emergencies.pop();
            boolean isAdded = false;
            if(!emergency.getClass().getSimpleName().contains(type)){
                this.emergencies.addFirst(emergency);
                continue;
            } else {
                for (int j = 0; j < this.centers.size(); j++) {
                    String centerType = "";
                    switch (type){
                        case "Health":
                            centerType = "MedicalServiceCenter";
                            break;
                        case "Order":
                            centerType = "PoliceServiceCenter";
                            break;
                        case "Property":
                            centerType = "FiremanServiceCenter";
                            break;
                    }
                    if(this.centers.get(j).getClass().getSimpleName().equalsIgnoreCase(centerType)){
                        EmergencyCenter center = this.centers.remove(j);
                        center.addEmergency(emergency);
                        isAdded = true;
                        if(center.isForRetirement()){
                            this.retiredCenters.add(center);
                        } else {
                            this.centers.addLast(center);
                        }
                    }
                }
            }
            if(!isAdded){
                this.emergencies.addFirst(emergency);
            }
            
        }
        if(this.emergencies.stream().noneMatch(x -> x.getClass().getSimpleName().contains(type))){
            return String.format("Successfully responded to all %s emergencies.", type);
        }
        return String.format("%s Emergencies left to process: %d.", type, this.emergencies.stream().filter(x -> x.getClass().getSimpleName().contains(type)).count());
    }

    @Override
    public String emergencyReport() {
        return String.format("PRRM Services Live Statistics%n" +
                "Fire Service Centers: %d%n" +
                "Medical Service Centers: %d%n" +
                "Police Service Centers: %d%n" +
                "Total Processed Emergencies: %d%n" +
                "Currently Registered Emergencies: %d%n" +
                "Total Property Damage Fixed: %d%n" +
                "Total Health Casualties Saved: %d%n" +
                "Total Special Cases Processed: %d%n",
                this.centers.stream().filter(x -> x instanceof FiremanServiceCenter).count(),
                this.centers.stream().filter(x -> x instanceof MedicalServiceCenter).count(),
                this.centers.stream().filter(x -> x instanceof PoliceServiceCenter).count(),
                this.centers.stream().mapToInt(x -> x.getEmergencies().size()).sum() + this.retiredCenters.stream().mapToInt(x -> x.getEmergencies().size()).sum(),
                this.emergencies.size(),
                this.centers.stream().filter(x -> x instanceof FiremanServiceCenter).mapToInt(x -> x.getEmergencies().stream().map(y -> (PublicPropertyEmergency)(y)).mapToInt(PublicPropertyEmergency::getDamage).sum()).sum(),
                this.centers.stream().filter(x -> x instanceof MedicalServiceCenter).mapToInt(x -> x.getEmergencies().stream().map(y -> (PublicHealthEmergency)y).mapToInt(PublicHealthEmergency::getNumberOfCasualties).sum()).sum(),
                this.centers.stream().filter(x -> x instanceof PoliceServiceCenter).mapToInt(x -> (int) x.getEmergencies().stream().map(y -> (PublicOrderEmergency)y).filter(PublicOrderEmergency::isSpecialCase).count()).sum());
    }

    @Override
    public String[] getInput() {
        return this.input;
    }

    @Override
    public void setInput(String[] input) {
        this.input = input;
    }
}
