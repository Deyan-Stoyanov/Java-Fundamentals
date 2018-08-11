package problem2_5_kings_gambit.commands;

import problem2_5_kings_gambit.abstractions.Command;
import problem2_5_kings_gambit.models.King;

public class AttackCommand implements Command {
    private King king;

    public AttackCommand(King king) {
        this.king = king;
    }


    @Override
    public void execute() {
        this.king.getAttacked();
    }
}

