package p03_employee_info.abstractions;

import p03_employee_info.classes.Employee;

public interface Formatter {
    String format(Iterable<Employee> list);
}
