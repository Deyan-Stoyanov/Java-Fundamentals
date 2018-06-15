package first_and_reserve_team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstSquad;
    private List<Person> reserve;

    public Team() {
        this.firstSquad = new ArrayList<>();
        this.reserve = new ArrayList<>();
    }

    public Team(String name) {
        this.name = name;
        this.firstSquad = new ArrayList<>();
        this.reserve = new ArrayList<>();
    }

    public Team(String name, List<Person> firstSquad, List<Person> reserve) {
        this.name = name;
        this.firstSquad = firstSquad;
        this.reserve = reserve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstSquad() {
        return Collections.unmodifiableList(this.firstSquad);
    }

    public List<Person> getReserve() {
        return Collections.unmodifiableList(this.reserve);
    }

    public void addPlayer(Person player){
        if(player.getAge() < 40){
            this.firstSquad.add(player);
        } else {
            this.reserve.add(player);
        }
    }

    @Override
    public String toString() {
        return String.format("First team have %d players%nReserve team have %d players", this.getFirstSquad().size(), this.getReserve().size());
    }
}
