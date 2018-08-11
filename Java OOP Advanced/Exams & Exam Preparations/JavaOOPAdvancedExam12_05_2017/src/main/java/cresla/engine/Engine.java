package cresla.engine;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.manager.ManagerImpl;
import cresla.util.CommandInterpreter;

public class Engine {
    private OutputWriter writer;
    private InputReader reader;
    private CommandInterpreter interpreter;

    public Engine(OutputWriter writer, InputReader reader) {
        this.reader = reader;
        this.writer = writer;
        this.interpreter = new CommandInterpreter(new ManagerImpl());
    }

    public void run() {
        while (true) {
            String input = this.reader.readLine();
            String result = this.interpreter.interpret(input);
            this.writer.writeLine(result);
            if (input.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }
}
