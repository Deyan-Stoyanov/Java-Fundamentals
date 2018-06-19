package football_team_generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private Double rating;
    private List<Player> players;

    public Team() {
        this.players = new ArrayList<>();
    }

    public Team(String name) {
        this();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.matches("\\s+")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public Double getRating() {
        this.setRating();
        return rating;
    }

    public void setRating() {
        this.rating = 0D;
        if(players.stream().mapToDouble(Player::getOverallSkill).average().isPresent()){
            this.rating = players.stream().mapToDouble(Player::getOverallSkill).average().getAsDouble();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayers(Player player){
        this.players.add(player);
    }
    public void removePlayers(String player){
        this.players.removeIf(x -> x.getName().equals(player));
    }
}
