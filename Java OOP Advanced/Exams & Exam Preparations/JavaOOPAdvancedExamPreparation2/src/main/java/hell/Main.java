package hell;

import hell.entities.engine.Engine;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(new LinkedHashMap<>(), new ConsoleReader(new BufferedReader(new InputStreamReader(System.in))) , new ConsoleWriter());
        engine.run();
    }
}