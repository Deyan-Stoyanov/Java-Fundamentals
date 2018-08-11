package app.models.participants;

import app.util.Config;

public class Warrior extends BaseHero {
    public Warrior(String name) {
        super(name);
        this.setStrength(Config.WARRIOR_BASE_STRENGTH);
        this.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        this.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    protected int getInitialHealth() {
        return Config.WARRIOR_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER;
    }
}
