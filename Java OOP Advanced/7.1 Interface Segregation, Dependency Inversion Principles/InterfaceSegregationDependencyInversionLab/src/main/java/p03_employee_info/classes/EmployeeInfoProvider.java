package p03_employee_info.classes;

import p03_employee_info.abstractions.Database;
import p03_employee_info.abstractions.Provider;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements Provider {

    private Database database;

    public EmployeeInfoProvider(Database database) {
        this.database = database;
    }

    public List<Employee> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    public Iterable<Employee> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
