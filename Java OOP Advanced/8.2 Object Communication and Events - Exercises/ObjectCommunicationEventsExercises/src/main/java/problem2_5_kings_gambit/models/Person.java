package problem2_5_kings_gambit.models;

import problem2_5_kings_gambit.abstractions.Killable;

public abstract class Person implements Killable {
    private String name;
    private int healthPoints;
    private boolean isDead;

    protected Person(String name) {
        this.name = name;
        this.isDead = false;
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public boolean isDead() {
        return this.isDead;
    }

    protected void setIsDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public void hit() {
        this.setHealthPoints(this.getHealthPoints() - 1);
        if(this.getHealthPoints() <= 0){
            this.setIsDead(true);
        }
    }
}
