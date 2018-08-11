package problem4_work_force.commands;

import problem4_work_force.abstractions.Command;

public class CommandExecutor {
    public static void executeCommand(Command command){
        command.execute();
    }
}
