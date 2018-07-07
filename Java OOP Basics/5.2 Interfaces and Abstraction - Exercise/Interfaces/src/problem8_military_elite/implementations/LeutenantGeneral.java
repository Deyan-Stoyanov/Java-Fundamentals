package problem8_military_elite.implementations;

import problem8_military_elite.abstract_classes.Soldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeutenantGeneral extends Soldier {
    private double salary;
    private List<Private> soldiers;

    public LeutenantGeneral(Integer id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
        this.soldiers = new ArrayList<>();
    }

    public List<Private> getSoldiers() {
        return Collections.unmodifiableList(this.soldiers);
    }

    public void addSoldier(Private priv){
        this.soldiers.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f%nPrivates:", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        this.getSoldiers().stream().sorted((x, y) -> y.getId().compareTo(x.getId())).forEach(x -> sb.append(System.lineSeparator()).append(x.toString()));
        return sb.toString();
    }

    public double getSalary() {
        return salary;
    }
}
