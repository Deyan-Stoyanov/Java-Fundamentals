package p03_employee_info.classes;

import p03_employee_info.abstractions.Writer;

public class ConsoleClient implements Writer {

    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
