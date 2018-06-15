package pokemon_class;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private long numberOfBadges;
    private Set<Pokemon> pokemons;

    public Trainer() {
    }

    public Trainer(String name) {
        this(name, 0L, new LinkedHashSet<>());
    }

    public Trainer(String name, long numberOfBadges, Set<Pokemon> pokemons) {
        this.name = name;
        this.numberOfBadges = numberOfBadges;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(long numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public Set<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void increaseBadges(String element){
        if(this.pokemons.stream().anyMatch(x -> x.getElement().equals(element))){
            this.numberOfBadges++;
        } else {
            this.pokemons.forEach(x -> x.setHealth(x.getHealth() - 10));
        }
        checkPokemons();
    }

    public void checkPokemons(){
        this.setPokemons(this.getPokemons()
                .stream()
                .filter(x -> x.getHealth() > 0)
                .collect(Collectors.toCollection(LinkedHashSet::new)));
    }
}
