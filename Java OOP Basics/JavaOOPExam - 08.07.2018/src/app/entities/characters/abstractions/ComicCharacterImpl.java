package app.entities.characters.abstractions;

import app.entities.powers.SuperPower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    public List<SuperPower> getPowers() {
        return Collections.unmodifiableList(this.powers);
    }

    protected void setName(String name) {
        if(!name.matches("[a-zA-Z_]{2,12}")){
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    protected void setEnergy(int energy) {
        if(energy < 0 || energy > 300){
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    protected void setHealth(double health) {
        if(health <= 0){
            throw new IllegalArgumentException("Health should be a positive number!");
        }
        this.health = health;
    }

    protected void setIntelligence(double intelligence) {
        if(intelligence <= 0 || intelligence > 200){
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    protected void setPowers(List<SuperPower> powers) {
        this.powers = powers;
    }

    @Override
    public void takeDamage(double damage) {
        this.health = (this.getHealth() - damage);
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String useSuperPowers() {
        if(this.getPowers().isEmpty()){
            return this.getName() + " has no super powers!";
        } else {
            for (SuperPower superPower : this.getPowers()) {
                this.setEnergy(this.getEnergy() + (int) superPower.getPowerPoints());
                this.setHealth(this.getHealth() + (superPower.getPowerPoints() * 2));
            }
        }
        return this.getName() + " used his super powers!";
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public String toString() {
        return String.format("#Name: %s%n" +
                "##Health: %.2f// Energy: %d// Intelligence: %.2f", this.getName(), this.getHealth(), this.getEnergy(), this.getIntelligence());
    }
}
