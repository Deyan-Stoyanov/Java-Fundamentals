package app.entities.arenas;

import app.entities.characters.abstractions.ComicCharacter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArenaImpl implements Arena{
    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.setArenaName(arenaName);
        this.setCapacity(capacity);
        this.heroes = new ArrayList<>();
        this.antiHeroes = new ArrayList<>();
    }


    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    @Override
    public boolean isArenaFull() {
        if((this.getAntiHeroes().size() + this.getHeroes().size()) >= this.capacity){
            return true;
        }
        return false;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.antiHeroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        if(this.heroes.isEmpty()){
            return false;
        } else if(this.antiHeroes.isEmpty()){
            return true;
        }

        if(this.heroes.size() >= this.antiHeroes.size()){
            while (true) {
                for (int i = 0; i < Math.min(heroes.size(), antiHeroes.size()); i++) {
                    this.heroes.get(i).takeDamage(this.antiHeroes.get(i).attack());
                    if (this.heroes.get(i).getHealth() <= 0) {
                        this.heroes.remove(i);
                    }
                    if (this.heroes.isEmpty()) {
                        return false;
                    } else if (antiHeroes.isEmpty()) {
                        return true;
                    }
                }
                for (int i = 0; i < Math.min(heroes.size(), antiHeroes.size()); i++) {
                    this.antiHeroes.get(i).takeDamage(this.heroes.get(i).attack());
                    if (this.antiHeroes.get(i).getHealth() <= 0) {
                        this.antiHeroes.remove(i);
                    }
                    if (this.heroes.isEmpty()) {
                        return false;
                    } else if (antiHeroes.isEmpty()) {
                        return true;
                    }
                }
            }
        } else {
            while (true) {
                for (int i = 0; i < Math.min(heroes.size(), antiHeroes.size()); i++) {
                    this.antiHeroes.get(i).takeDamage(this.heroes.get(i).attack());
                    if (this.antiHeroes.get(i).getHealth() <= 0) {
                        this.antiHeroes.remove(i);
                    }
                    if (this.heroes.isEmpty()) {
                        return false;
                    } else if (antiHeroes.isEmpty()) {
                        return true;
                    }
                }
                for (int i = 0; i < Math.min(heroes.size(), antiHeroes.size()); i++) {
                    this.heroes.get(i).takeDamage(this.antiHeroes.get(i).attack());
                    if (this.heroes.get(i).getHealth() <= 0) {
                        this.heroes.remove(i);
                    }
                    if (this.heroes.isEmpty()) {
                        return false;
                    } else if (antiHeroes.isEmpty()) {
                        return true;
                    }
                }
            }
        }
    }

    private void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public List<ComicCharacter> getHeroes() {
        return Collections.unmodifiableList(this.heroes);
    }

    @Override
    public List<ComicCharacter> getAntiHeroes() {
        return Collections.unmodifiableList(this.antiHeroes);
    }
}
