package problem4_work_force.commands;

import problem4_work_force.abstractions.Command;
import problem4_work_force.abstractions.Employee;
import problem4_work_force.factories.JobFactory;
import problem4_work_force.models.Job;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CreateJobCommand implements Command {
    private String name;
    private int hours;
    private String employeeName;
    private Map<String, Employee> employees;
    private Map<String, Job> jobs;

    public CreateJobCommand(String name, int hours, String employeeName, Map<String, Employee> employees, Map<String, Job> jobs) {
        this.name = name;
        this.hours = hours;
        this.employeeName = employeeName;
        this.employees = employees;
        this.jobs = jobs;
    }


    @Override
    public void execute() {
        try {
            this.jobs.put(this.name, JobFactory.createJob(this.name, this.hours, this.employees.get(this.employeeName)));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
