package app.models.specials;

import app.contracts.Targetable;

public class Swiftness extends SpecialAbility {

    public Swiftness() {
        super();
    }

    @Override
    public boolean requirementsMet(Targetable targetable, int initialHealth) {
        return targetable.getHealth() >= initialHealth / 2;
    }
}
