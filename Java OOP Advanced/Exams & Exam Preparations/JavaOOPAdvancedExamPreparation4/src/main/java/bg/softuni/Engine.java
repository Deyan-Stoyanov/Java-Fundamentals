package bg.softuni;

import bg.softuni.abstractions.InputReader;
import bg.softuni.abstractions.ManagementSystem;
import bg.softuni.abstractions.OutputWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Engine {
    private OutputWriter writer;
    private InputReader reader;
    private ManagementSystem system;

    public Engine(OutputWriter writer, InputReader reader, ManagementSystem system) {
        this.writer = writer;
        this.reader = reader;
        this.system = system;
    }

    public void run() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String command;
        while (!"EmergencyBreak".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("\\|");
            String s = tokens[0].replace(tokens[0].charAt(0), String.valueOf(tokens[0].charAt(0)).toLowerCase().charAt(0));

            Method method = system.getClass().getDeclaredMethod(s);
            this.system.setInput(tokens);
            method.setAccessible(true);
            String result = (String) method.invoke(this.system);
            this.writer.printLine(result);
        }
    }
}
