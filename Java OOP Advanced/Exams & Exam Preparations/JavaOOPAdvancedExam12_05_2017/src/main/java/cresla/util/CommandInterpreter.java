package cresla.util;

import cresla.interfaces.Manager;

import java.util.Arrays;
import java.util.List;

public class CommandInterpreter {
    private Manager manager;

    public CommandInterpreter(Manager manager) {
        this.manager = manager;
    }

    public String interpret(String input) {
        List<String> commands = Arrays.asList(input.split("\\s+"));
        String command = commands.get(0);
        switch (command) {
            case "Reactor":
                return this.manager.reactorCommand(commands);
            case "Module":
                return this.manager.moduleCommand(commands);
            case "Report":
                return this.manager.reportCommand(commands);
            case "Exit":
                return this.manager.exitCommand(commands);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
