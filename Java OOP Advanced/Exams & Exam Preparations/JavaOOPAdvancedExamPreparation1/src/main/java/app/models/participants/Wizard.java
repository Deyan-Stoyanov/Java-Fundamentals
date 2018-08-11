package app.models.participants;

import app.contracts.Targetable;
import app.util.Config;

public class Wizard extends BaseHero {
    public Wizard(String name) {
        super(name);
        this.setStrength(Config.WIZARD_BASE_STRENGTH);
        this.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        this.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

    @Override
    protected int getInitialHealth() {
        return Config.WIZARD_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER;
    }
}
