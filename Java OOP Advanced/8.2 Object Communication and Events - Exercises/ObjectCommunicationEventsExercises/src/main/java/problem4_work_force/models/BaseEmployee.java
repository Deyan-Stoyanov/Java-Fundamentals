package problem4_work_force.models;

import problem4_work_force.abstractions.Employee;

public abstract class BaseEmployee implements Employee {
    private String name;
    private int workingHoursPerWeek;

    protected BaseEmployee(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public int getWorkingHoursPerWeek() {
        return this.workingHoursPerWeek;
    }

    protected void setWorkingHoursPerWeek(int workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }
}
