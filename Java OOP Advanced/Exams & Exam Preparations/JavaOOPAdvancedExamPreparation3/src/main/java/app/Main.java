package app;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.engine.Engine;
import app.waste_disposal.io.ConsoleReader;
import app.waste_disposal.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine(new ConsoleReader(), new ConsoleWriter(), new DefaultGarbageProcessor());
        engine.run();
    }
}
