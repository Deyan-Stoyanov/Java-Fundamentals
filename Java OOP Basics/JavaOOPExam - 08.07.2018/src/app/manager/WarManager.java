package app.manager;

import app.entities.arenas.Arena;
import app.entities.characters.abstractions.ComicCharacter;
import app.entities.powers.SuperPower;

import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {
    private Map<String, ComicCharacter> comicCharacters;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> superPowers;
    private int heroesWins;
    private int antiHeroesWins;

    public WarManager() {
        this.comicCharacters = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.superPowers = new LinkedHashMap<>();
        heroesWins = 0;
        antiHeroesWins = 0;
    }

    @Override
    public String checkComicCharacter(String characterName) {
        if (this.comicCharacters.containsKey(characterName)) {
            if (this.comicCharacters.get(characterName).getHealth() <= 0) {
                return this.comicCharacters.get(characterName).getName() + " has fallen in battle!";
            }
            return this.comicCharacters.get(characterName).toString();
        }
        return String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if (comicCharacters.containsKey(hero.getName())) {
            comicCharacters.get(hero.getName()).boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return hero.getName() + " evolved!";
        }
        this.comicCharacters.put(hero.getName(), hero);
        return hero.getName() + " is ready for battle!";
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if (comicCharacters.containsKey(antiHero.getName())) {
            comicCharacters.get(antiHero.getName()).boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
            return antiHero.getName() + " is getting stronger!";
        }
        this.comicCharacters.put(antiHero.getName(), antiHero);
        return antiHero.getName() + " is ready for destruction!";
    }

    @Override
    public String addArena(Arena arena) {
        if (this.arenas.containsKey(arena.getArenaName())) {
            return "A battle is about to start there!";
        }
        this.arenas.put(arena.getArenaName(), arena);
        return arena.getArenaName() + " is becoming a fighting ground!";
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        if (this.arenas.values().stream().anyMatch(x -> x.getHeroes().contains(this.comicCharacters.get(hero)))) {
            if(this.arenas.get(arena).getHeroes().stream().anyMatch(x -> x.getName().equals(hero))){
                if (this.arenas.get(arena).getHeroes().stream().filter(x -> x.getName().equals(hero)).findFirst().get().getHealth() <= 0) {
                    return hero + " is dead!";
                }
            }
            return hero + " is fighting!";
        } else {
            if (this.arenas.get(arena).isArenaFull()) {
                return "Arena is full!";
            }
            this.arenas.get(arena).addHero(this.comicCharacters.get(hero));
            return hero + " is fighting for your freedom in " + arena + "!";
        }
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        if (this.arenas.get(arena).getAntiHeroes().stream().anyMatch(x -> x.getName().equals(antiHero))) {
            if (this.arenas.get(arena).getAntiHeroes().stream().filter(x -> x.getName().equals(antiHero)).findFirst().get().getHealth() <= 0) {
                return antiHero + " is dead!";
            }
            return antiHero + " is fighting!";
        } else {
            if (this.arenas.get(arena).isArenaFull()) {
                return "Arena is full!";
            }
            this.arenas.get(arena).addAntiHero(this.comicCharacters.get(antiHero));
            return antiHero + " and his colleagues are trying to take over " + arena + "!";
        }
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if (this.superPowers.containsKey(superPower.getName())) {
            return "This super power already exists!";
        }
        this.superPowers.put(superPower.getName(), superPower);
        return superPower.getName() + " added to pool!";
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        if (!this.superPowers.containsKey(superPower)) {
            return superPower + " already assigned!";
        }
        this.comicCharacters.get(comicCharacter).addSuperPower(this.superPowers.get(superPower));
        this.superPowers.remove(superPower);
        return comicCharacter + " has a new super power!";
    }

    @Override
    public String usePowers(String characterName) {
        return this.comicCharacters.get(characterName).useSuperPowers();
    }

    @Override
    public String startBattle(String arena) {
        if (this.arenas.get(arena).getHeroes().isEmpty()) {
            return "SAFE ZONE!";
        }
        Arena currentArena = this.arenas.get(arena);
        boolean heroesWon = currentArena.fightHeroes();
        if (heroesWon) {
            this.heroesWins++;
            this.arenas.remove(arena);
            return "Heroes won the battle of " + arena + "!";
        }
        this.antiHeroesWins++;
        this.arenas.remove(arena);
        return "Anti Heroes won the battle of " + arena + "!";
    }

    @Override
    public String endWar() {
        if (this.heroesWins >= this.antiHeroesWins) {
            return String.format("After %d battles our FRIENDLY HEROES WON!", heroesWins + antiHeroesWins);
        }
        return "WE ARE DOOMED!";
    }
}
