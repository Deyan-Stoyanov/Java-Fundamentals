package java_advanced_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Player> players = new ArrayList<>();
        String command;
        while(!"osu!".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("[\\s<>\\-]+");
            String firstName = input[1];
            String secondName = input[2];
            long firstDiff = Integer.parseInt(input[0]) - Integer.parseInt(input[3]);
            long secondDiff = Integer.parseInt(input[3]) - Integer.parseInt(input[0]);
            String firstMatch = secondName + " <-> " + firstDiff;
            String secondMatch = firstName + " <-> " + secondDiff;
            Player firstPlayer = new Player(firstName, firstDiff, new ArrayList<>());
            firstPlayer.getOpponentsAndGainedPoints().add(firstMatch);
            Player secondPlayer = new Player(secondName, secondDiff, new ArrayList<>());
            secondPlayer.getOpponentsAndGainedPoints().add(secondMatch);
            addPlayerData(players, firstName, firstDiff, firstMatch, firstPlayer);
            addPlayerData(players, secondName, secondDiff, secondMatch, secondPlayer);
        }
        players = players.stream().sorted((x, y) -> Long.compare(y.getPoints(), x.getPoints())).collect(Collectors.toCollection(ArrayList::new));
        for (Player player : players) {
            System.out.printf("%s - (%d)%n", player.getName(), player.getPoints());
            for (String s : player.getOpponentsAndGainedPoints()) {
                System.out.printf("*   %s%n", s);
            }
        }
    }

    private static void addPlayerData(List<Player> players, String name, long diff, String match, Player player) {
        if(players.stream().anyMatch(x -> x.getName().equals(name))){
            for (Player pl : players) {
                if(pl.getName().equals(name)){
                    pl.setPoints(pl.getPoints() + diff);
                    pl.getOpponentsAndGainedPoints().add(match);
                }
            }
        }else {
            players.add(player);
        }
    }

    private static class Player {
        private String name;
        private long points;
        private List<String> opponentsAndGainedPoints;

        public Player(String name, long points, List<String> opponentsAndGainedPoints) {
            this.name = name;
            this.points = points;
            this.opponentsAndGainedPoints = new ArrayList<>();
        }

        public Player() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPoints() {
            return points;
        }

        public void setPoints(long points) {
            this.points = points;
        }

        public List<String> getOpponentsAndGainedPoints() {
            return opponentsAndGainedPoints;
        }

        public void setOpponentsAndGainedPoints(List<String> opponentsAndGainedPoints) {
            this.opponentsAndGainedPoints = opponentsAndGainedPoints;
        }
    }
}
