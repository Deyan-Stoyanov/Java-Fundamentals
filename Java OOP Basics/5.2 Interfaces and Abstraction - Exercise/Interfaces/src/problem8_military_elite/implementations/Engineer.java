package problem8_military_elite.implementations;

import problem8_military_elite.units.Repair;
import problem8_military_elite.abstract_classes.SpecialisedSoldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier {
    private List<Repair> repairs;
    private double salary;

    public Engineer(Integer id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, corps);
        this.salary = salary;
        this.repairs = new ArrayList();
    }

    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    private void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%nRepairs:", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary(), this.getCorps()));
        this.getRepairs().forEach(x -> sb.append(System.lineSeparator()).append("  ").append(x.toString()));
        return sb.toString();
    }

    public double getSalary() {
        return salary;
    }

    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }
}
