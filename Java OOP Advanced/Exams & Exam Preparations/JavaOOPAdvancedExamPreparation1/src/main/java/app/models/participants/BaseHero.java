package app.models.participants;

import app.contracts.Hero;
import app.contracts.Special;
import app.contracts.SpecialHero;
import app.contracts.Targetable;
import app.util.Config;

public abstract class BaseHero implements SpecialHero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;
    private double health;
    private String name;
    private boolean isAlive;
    private double gold;
    private Special specialAbility;

    protected BaseHero(String name) {
        this.name = name;
        this.isAlive = true;
        this.level = 1;
        this.gold = Config.HERO_START_GOLD;
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + Config.ATTACKER_DEAD_MESSAGE;
        }
        if (!target.isAlive()) {
            return target.getName() + Config.TARGET_DEAD_MESSAGE;
        }
        target.takeDamage(this.getDamage());
        String result = this.getName() + Config.TARGET_ATTACKED_MESSAGE;
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(Config.TARGET_SLAIN_MESSAGE, target.getName(), this.getName());
        }
        return result;
    }

    @Override
    public void receiveReward(double reward) {
        this.gold += reward;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0) {
            this.die();
        }
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
        this.setHealth(strength * Config.HERO_HEALTH_MULTIPLIER);
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = health;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.gold);
        this.gold = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public abstract double getDamage();

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void levelUp() {
        this.setDexterity(this.getDexterity() * Config.LEVEL_UP_MULTIPLIER);
        this.setIntelligence(this.getIntelligence() * Config.LEVEL_UP_MULTIPLIER);
        this.setStrength(this.getStrength() * Config.LEVEL_UP_MULTIPLIER);
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.level++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s", this.getName(), this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append(String.format("  Health: %.2f | Damage: %.2f", this.getHealth(), this.getDamage()))
                .append(System.lineSeparator())
                .append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }

    public int getLevel() {
        return this.level;
    }

    private void die() {
        isAlive = false;
    }

    @Override
    public void assignAbility(Special special) {
        this.specialAbility = special;
    }

    protected abstract int getInitialHealth();

    @Override
    public void activateAbility() {
        if (this.specialAbility != null) {
            if (this.specialAbility.requirementsMet(this, this.getInitialHealth())) {
                switch (this.specialAbility.getType()) {
                    case "Heal":
                        this.setHealth(this.getHealth() + this.getIntelligence());
                        break;
                    case "Toughness":
                        this.strength += this.getIntelligence();
                        break;
                    case "Swiftness":
                        this.setDexterity(this.getDexterity() + this.getIntelligence());
                        break;
                }
            }
        }
    }

    @Override
    public void deactivateAbility() {
        if (this.specialAbility != null) {
            switch (this.specialAbility.getType()) {
                case "Heal":
                    this.setHealth(this.getHealth() - this.getIntelligence());
                    break;
                case "Toughness":
                    this.strength += this.getIntelligence();
                    break;
                case "Swiftness":
                    this.setDexterity(this.getDexterity() - this.getIntelligence());
                    break;
            }
        }
    }

    @Override
    public Special getSpecial() {
        return this.specialAbility;
    }
}
