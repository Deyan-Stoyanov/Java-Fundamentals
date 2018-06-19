package football_team_generator;

import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private List<Double> stats;
    private Double overallSkill;

    public Player() {
        this.stats = new ArrayList<>();
    }

    public Player(String name) {
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

    public List<Double> getStats() {
        return Collections.unmodifiableList(this.stats);
    }

    public void setStats(String[] stats) {
        if(Double.parseDouble(stats[0]) < 0 || Double.parseDouble(stats[0]) > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        if(Double.parseDouble(stats[1]) < 0 || Double.parseDouble(stats[1]) > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        if(Double.parseDouble(stats[2]) < 0 || Double.parseDouble(stats[2]) > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        if(Double.parseDouble(stats[3]) < 0 || Double.parseDouble(stats[3]) > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        if(Double.parseDouble(stats[4]) < 0 || Double.parseDouble(stats[4]) > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.stats = Arrays.stream(stats).map(Double::parseDouble).collect(Collectors.toCollection(ArrayList::new));
    }

    public Double getOverallSkill() {
        this.setOverallSkill();
        return this.overallSkill;
    }

    public void setOverallSkill() {
        this.overallSkill = this.stats.stream().mapToDouble(Double::valueOf).average().getAsDouble();
    }
}
