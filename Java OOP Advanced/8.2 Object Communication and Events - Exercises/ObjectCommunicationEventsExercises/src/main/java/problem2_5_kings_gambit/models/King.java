package problem2_5_kings_gambit.models;

import problem2_5_kings_gambit.abstractions.Attackable;
import problem2_5_kings_gambit.factories.FootmanFactory;
import problem2_5_kings_gambit.factories.RoyalGuardFactory;

import java.util.LinkedHashSet;
import java.util.Set;

public class King implements Attackable {

    private String name;
    private Set<Footman> footmen;
    private Set<RoyalGuard> royalGuards;

    public King(String name) {
        this.name = name;
        this.footmen = new LinkedHashSet<>();
        this.royalGuards = new LinkedHashSet<>();
    }

    @Override
    public void getAttacked() {
        System.out.printf("King %s is under attack!%n", this.getName());
        this.royalGuards.forEach(RoyalGuard::behave);
        this.footmen.forEach(Footman::behave);
    }

    public void addFootman(String name) {
        this.footmen.add(FootmanFactory.createFootman(name));
    }

    public void addRoyalGuard(String name) {
        this.royalGuards.add(RoyalGuardFactory.createRoyalGuard(name));
    }

    public void killPerson(String name){
        if(footmen.stream().anyMatch(x -> x.getName().equals(name))){
            footmen.stream().filter(x -> x.getName().equals(name)).forEach(Person::hit);
            footmen.removeIf(Person::isDead);
        } else {
            royalGuards.stream().filter(x -> x.getName().equals(name)).forEach(Person::hit);
            royalGuards.removeIf(Person::isDead);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
