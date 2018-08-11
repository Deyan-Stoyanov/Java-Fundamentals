package models;

import abstractions.Target;
import enums.LogType;
import abstractions.Handler;

public class Warrior extends AbstractHero {

    private static final String ATTACK_MESSAGE = "%s damages %s for %s";

    public Warrior(String id, int dmg, Handler handler) {
        super(id, dmg, handler);
    }

    @Override
    protected void executeClassSpecificAttack(Target target, int dmg) {
        this.getHandler().handle(LogType.ATTACK, String.format(ATTACK_MESSAGE, this, target, dmg));
        target.receiveDamage(dmg);
    }
}
