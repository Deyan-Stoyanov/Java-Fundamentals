package problem4_work_force.commands;

import problem4_work_force.abstractions.Command;
import problem4_work_force.abstractions.Employee;
import problem4_work_force.factories.EmployeeFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CreateEmployeeCommand implements Command {
    private String type;
    private String name;
    private Map<String, Employee> employees;

    public CreateEmployeeCommand(String type, String name, Map<String, Employee> employees) {
        this.type = type;
        this.name = name;
        this.employees = employees;
    }

    @Override
    public void execute() {
        try {
            this.employees.put(this.name, EmployeeFactory.createEmployee(this.type, this.name));
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
