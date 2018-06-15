package google_class;

import java.util.LinkedHashSet;
import java.util.Set;

public class Person {
    private String name;
    private Company company;
    private Set<Pokemon> pokemons;
    private Set<Relative> parents;
    private Set<Relative> children;
    private Car car;

    public Person() {
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.pokemons = new LinkedHashSet<>();
    }

    public Person(String name) {
        this.name = name;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
        this.pokemons = new LinkedHashSet<>();
    }

    public Person(String name, Company company, Set<Pokemon> pokemon, Set<Relative> parents, Set<Relative> children, Car car) {
        this.name = name;
        this.company = company;
        this.pokemons = pokemon;
        this.parents = parents;
        this.children = children;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Set<Relative> getParents() {
        return parents;
    }

    public void setParents(Set<Relative> parents) {
        this.parents = parents;
    }

    public Set<Relative> getChildren() {
        return children;
    }

    public void setChildren(Set<Relative> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
