package app.models.specials;

import app.contracts.Special;

public abstract class SpecialAbility implements Special {

    public SpecialAbility() {
    }

    @Override
    public String getType(){
        return this.getClass().getSimpleName();
    }
}
