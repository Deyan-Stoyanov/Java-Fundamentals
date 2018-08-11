package problem2_5_kings_gambit.commands;

import problem2_5_kings_gambit.abstractions.Command;
import problem2_5_kings_gambit.models.King;

public class KillCommand implements Command {
    private King king;
    private String soldierToKill;

    public KillCommand(King king, String soldierToKill) {
        this.king = king;
        this.soldierToKill = soldierToKill;
    }

    @Override
    public void execute() {
        this.king.killPerson(soldierToKill);
    }
}
