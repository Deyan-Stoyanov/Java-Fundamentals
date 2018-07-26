package app.entities.characters.abstractions;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    protected AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    public double getEvilness() {
        return this.evilness;
    }

    public void setEvilness(double evilness) {
        if(evilness <= 0){
            throw new IllegalArgumentException("Evilness should be a positive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.getEvilness();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n###Evilness: %.2f", this.getSpecial());
    }
}
