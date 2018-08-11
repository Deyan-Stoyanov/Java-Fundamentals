package p03_employee_info.classes;

import p03_employee_info.abstractions.Formatter;

public class ConsoleFormatter implements Formatter {

    public String format(Iterable<Employee> employees) {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
