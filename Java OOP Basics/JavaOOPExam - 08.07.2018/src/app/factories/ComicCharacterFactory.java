package app.factories;

import app.entities.characters.abstractions.AntiHero;
import app.entities.characters.abstractions.Hero;
import app.entities.characters.classes.DCHero;
import app.entities.characters.classes.MarvelHero;
import app.entities.characters.classes.Titan;
import app.entities.characters.classes.Villain;

public final class ComicCharacterFactory {

    private ComicCharacterFactory() {
    }

    public static Hero createHero(String name, String type, int energy, double health, double intelligence, double heroism) {
        switch (type) {
            case "MarvelHero":
                return new MarvelHero(name, energy, health, intelligence, heroism);
            case "DCHero":
                return new DCHero(name, energy, health, intelligence, heroism);
            default:
                return null;
        }
    }

    public static AntiHero createAntiHero(String name, String type, int energy, double health, double intelligence, double evilness) {
        switch (type) {
            case "Villain":
                return new Villain(name, energy, health, intelligence, evilness);
            case "Titan":
                return new Titan(name, energy, health, intelligence, evilness);
            default:
                return null;
        }
    }
}
