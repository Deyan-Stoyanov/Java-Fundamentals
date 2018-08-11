package app.models.participants;

import app.util.Config;

public class Necromancer extends BaseHero {
    public Necromancer(String name) {
        super(name);
        this.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        this.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        this.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + (this.getDexterity() * 2) + (this.getIntelligence() * 2);
    }

    @Override
    protected int getInitialHealth() {
        return Config.NECROMANCER_BASE_STRENGTH * Config.HERO_HEALTH_MULTIPLIER;
    }
}
