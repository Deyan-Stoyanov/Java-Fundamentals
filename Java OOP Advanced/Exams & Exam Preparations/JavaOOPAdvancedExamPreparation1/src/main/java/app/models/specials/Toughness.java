package app.models.specials;

import app.contracts.Targetable;

public class Toughness extends SpecialAbility {

    public Toughness() {
        super();
    }

    @Override
    public boolean requirementsMet(Targetable targetable, int initialHealth) {
        return targetable.getHealth() <= initialHealth / 2;
    }
}
