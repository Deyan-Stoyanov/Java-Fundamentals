package panzer;

import panzer.contracts.BattleOperator;
import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.core.PanzerBattleOperator;
import panzer.engine.Engine;
import panzer.io.ConsoleReader;
import panzer.io.ConsoleWriter;
import panzer.manager.PanzerManager;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        BattleOperator operator = new PanzerBattleOperator();
        Manager manager = new PanzerManager(operator);
        Engine engine = new Engine(reader, writer, manager);
        engine.run();
    }
}
