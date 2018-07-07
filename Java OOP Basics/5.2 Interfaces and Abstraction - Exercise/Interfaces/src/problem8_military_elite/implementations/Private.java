package problem8_military_elite.implementations;

import problem8_military_elite.abstract_classes.Soldier;

public class Private extends Soldier {
    private double salary;

    public Private(Integer id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary());
    }
}
