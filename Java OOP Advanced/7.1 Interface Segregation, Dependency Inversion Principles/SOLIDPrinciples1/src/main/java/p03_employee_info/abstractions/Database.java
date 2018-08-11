package p03_employee_info.abstractions;

import p03_employee_info.classes.Employee;

import java.util.List;

public interface Database {
    List<Employee> readEmployees();
}
