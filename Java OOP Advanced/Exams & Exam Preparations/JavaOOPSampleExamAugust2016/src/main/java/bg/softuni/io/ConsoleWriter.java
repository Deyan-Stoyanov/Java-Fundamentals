package bg.softuni.io;

import bg.softuni.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void write(String line) {
        System.out.print(line);
    }
}
