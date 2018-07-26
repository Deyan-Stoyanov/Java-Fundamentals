package app.entities.characters.abstractions;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    protected Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public double getHeroism() {
        return this.heroism;
    }

    private void setHeroism(double heroism) {
        if(heroism <= 0){
            throw new IllegalArgumentException("Heroism should be a positive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.getHeroism();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n###Heroism: %.2f", this.getSpecial());
    }
}
