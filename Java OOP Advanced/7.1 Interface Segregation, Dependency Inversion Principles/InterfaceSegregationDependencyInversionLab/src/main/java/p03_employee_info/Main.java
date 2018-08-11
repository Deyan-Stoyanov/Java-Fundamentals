package p03_employee_info;

import p03_employee_info.abstractions.Formatter;
import p03_employee_info.abstractions.Provider;
import p03_employee_info.abstractions.Writer;
import p03_employee_info.classes.ConsoleClient;
import p03_employee_info.classes.ConsoleFormatter;
import p03_employee_info.classes.EmployeeDatabase;
import p03_employee_info.classes.EmployeeInfoProvider;

public class Main {

    public static void main(String[] args) {
        Provider employeeInfo = new EmployeeInfoProvider(new EmployeeDatabase());
        Formatter formatter = new ConsoleFormatter();

        Writer writer = new ConsoleClient();
        writer.write(formatter.format(employeeInfo.getEmployeesBySalary()));
    }
}
