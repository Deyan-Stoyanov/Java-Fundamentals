package problem2_5_kings_gambit.commands;

import problem2_5_kings_gambit.abstractions.Command;

public class CommandExecutor {
    public static void executeCommand(Command command){
        command.execute();
    }
}
