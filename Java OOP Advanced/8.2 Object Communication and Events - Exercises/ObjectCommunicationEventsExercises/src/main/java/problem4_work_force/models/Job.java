package problem4_work_force.models;

import problem4_work_force.abstractions.Employee;
import problem4_work_force.handlers.Handler;

public class Job {
    private String name;
    private int hoursNeeded;
    private Employee employee;
    private boolean isDone;
    private Handler handler;

    public Job(String name, int hoursNeeded, Employee employee) {
        this.name = name;
        this.hoursNeeded = hoursNeeded;
        this.employee = employee;
        this.isDone = false;
        this.handler = new Handler();
    }

    public String getName() {
        return this.name;
    }

    public int getHoursNeeded() {
        return this.hoursNeeded;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void update(){
        this.hoursNeeded -= this.employee.getWorkingHoursPerWeek();
        if(this.getHoursNeeded() <= 0){
            this.handler.handleEvent(this);
            this.isDone = true;
        }
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursNeeded());
    }
}
