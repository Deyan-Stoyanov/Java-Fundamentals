package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;

public class FightCommand extends Command {
    public FightCommand() { }

    @Override
    public String execute() {
        return "fight";
    }
}
