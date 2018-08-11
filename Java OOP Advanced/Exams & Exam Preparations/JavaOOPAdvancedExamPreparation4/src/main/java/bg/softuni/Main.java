package bg.softuni;

import bg.softuni.core.EmergencyManagementSystem;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        Engine engine = new Engine(new ConsoleWriter(), new ConsoleReader(), new EmergencyManagementSystem());
        engine.run();
    }
}
