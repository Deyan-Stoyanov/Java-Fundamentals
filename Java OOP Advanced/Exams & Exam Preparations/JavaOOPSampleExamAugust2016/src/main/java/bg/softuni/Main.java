package bg.softuni;

import bg.softuni.engine.EngineImpl;
import bg.softuni.interfaces.Engine;
import bg.softuni.interfaces.InputReader;
import bg.softuni.interfaces.Manager;
import bg.softuni.interfaces.OutputWriter;
import bg.softuni.io.ConsoleReader;
import bg.softuni.io.ConsoleWriter;
import bg.softuni.manager.ManagerImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        Manager manager = new ManagerImpl();
        Engine engine = new EngineImpl(reader, writer, manager);
        engine.run();
    }
}
