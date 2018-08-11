package p03_employee_info.abstractions;

import p03_employee_info.classes.Employee;

import java.util.List;

public interface Provider {
    List<Employee> getEmployeesByName();
    Iterable<Employee> getEmployeesBySalary();
}
