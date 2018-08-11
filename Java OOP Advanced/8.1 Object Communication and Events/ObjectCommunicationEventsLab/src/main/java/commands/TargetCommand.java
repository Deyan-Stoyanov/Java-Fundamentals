package commands;

import abstractions.Command;
import abstractions.Attacker;
import abstractions.Target;

public class TargetCommand implements Command {

    private Target target;
    private Attacker attacker;

    public TargetCommand(Attacker attacker, Target target) {
        this.target = target;
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(target);
    }
}
