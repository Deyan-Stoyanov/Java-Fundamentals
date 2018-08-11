package app.models.specials;

import app.contracts.Targetable;

public class Heal extends SpecialAbility {

    public Heal() {
        super();
    }

    @Override
    public boolean requirementsMet(Targetable targetable, int initialHealth) {
        return targetable.getHealth() <= initialHealth / 2;
    }
}
