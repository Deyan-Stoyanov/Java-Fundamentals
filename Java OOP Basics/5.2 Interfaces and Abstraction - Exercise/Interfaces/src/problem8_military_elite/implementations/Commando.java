package problem8_military_elite.implementations;

import problem8_military_elite.units.Mission;
import problem8_military_elite.abstract_classes.SpecialisedSoldier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier {
    private double salary;
    private List<Mission> missions;
    public Commando(Integer id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, corps);
        this.salary = salary;
        this.missions = new ArrayList<>();
    }

    @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nMissions:", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary(), this.getCorps()));
            this.getMissions().forEach(x -> sb.append(System.lineSeparator()).append("  ").append(x));
            return sb.toString();
        }

    public double getSalary() {
        return this.salary;
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    public void addMission(Mission mission){
        this.missions.add(mission);
    }
}
