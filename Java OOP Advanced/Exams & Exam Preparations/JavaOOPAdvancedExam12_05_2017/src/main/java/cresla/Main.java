package cresla;

import cresla.engine.Engine;
import cresla.io.ConsoleReader;
import cresla.io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(new ConsoleWriter(), new ConsoleReader());
        engine.run();
    }
}
