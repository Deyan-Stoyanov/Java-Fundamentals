package app.models.participants;

import app.contracts.Targetable;
import app.util.Config;

public class Boss implements Targetable {

    private String name;
    private double health;
    private double damage;
    private double gold;
    private boolean isAlive;

    public Boss(String name) {
        this.name = name;
        this.health = Config.BOSS_HEALTH;
        this.damage = Config.BOSS_DAMAGE;
        this.gold = Config.BOSS_GOLD;
        this.isAlive = true;
    }

    @Override
    public String attack(Targetable target) {
        StringBuilder sb = new StringBuilder();
        if(!this.isAlive()){
            sb.append(Config.ATTACKER_DEAD_MESSAGE);
        } else if(!target.isAlive()){
            sb.append(target.getName()).append(Config.TARGET_DEAD_MESSAGE);
        } else {
            target.takeDamage(this.getDamage());
            sb.append(this.getName()).append(Config.TARGET_ATTACKED_MESSAGE);
            if(!target.isAlive()){
                this.receiveReward(target.getGold());
                sb.append(String.format(Config.TARGET_SLAIN_MESSAGE, target.getName(), this.getName()));
            }
        }
        return sb.toString();
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if(this.getHealth() <= 0){
            this.die();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(double health) {
this.health = health;
    }

    @Override
    public double getGold() {
        return this.gold;
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(this.getGold());
    }

    @Override
    public void receiveReward(double reward) {
        this.setGold(this.getGold() + (reward * Config.BOSS_GOLD_MULTIPLIER));
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Class: %s%nHealth: %.2f | Damage: %.2f | %.2f Gold",
                this.getName(), this.getClass().getSimpleName(), this.getHealth(), this.getDamage(), this.getGold());
    }

    private void die() {
        isAlive = false;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }
}
