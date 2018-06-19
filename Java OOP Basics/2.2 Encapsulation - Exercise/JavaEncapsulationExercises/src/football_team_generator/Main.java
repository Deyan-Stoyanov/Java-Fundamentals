package football_team_generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Team> teams = new ArrayList<>();
        applyCommands(reader, teams);
    }

    private static void applyCommands(BufferedReader reader, List<Team> teams) throws IOException {
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(";");
            switch (input[0]) {
                case "Team":
                    addTeam(teams, input[1]);
                    break;
                case "Add":
                    addPlayer(teams, input);
                    break;
                case "Remove":
                    removePlayer(teams, input);
                    break;
                case "Rating":
                    getTeamRating(teams, input[1]);
                    break;
                default:
                    break;
            }
        }
    }

    private static void getTeamRating(List<Team> teams, String teamName) {
        if (teams.stream().anyMatch(x -> x.getName().equals(teamName))) {
            for (Team team : teams) {
                if (team.getName().equals(teamName)) {
                    System.out.println(team.getName() + " - " + Math.round(team.getRating()));
                }
            }
        } else {
            System.out.printf("Team %s does not exist.%n", teamName);
        }
    }

    private static void removePlayer(List<Team> teams, String[] input) {
        if (teams.stream().anyMatch(x -> x.getName().equals(input[1]))) {
            for (Team team : teams) {
                if (team.getName().equals(input[1])) {
                    if (team.getPlayers().stream().anyMatch(x -> x.getName().equals(input[2]))) {
                        team.removePlayers(input[2]);
                    } else {
                        System.out.printf("Player %s is not in %s team.%n", input[2], input[1]);
                    }
                }
            }
        } else {
            System.out.printf("Team %s does not exist.%n", input[1]);
        }
    }

    private static void addPlayer(List<Team> teams, String[] input) {
        if (teams.stream().anyMatch(x -> x.getName().equals(input[1]))) {
            for (Team team : teams) {
                if (team.getName().equals(input[1])) {
                    try {
                        Player player = new Player(input[2]);
                        player.setStats(new String[]{input[3], input[4], input[5], input[6], input[7]});
                        team.addPlayers(player);
                    } catch (IllegalArgumentException ie){
                        System.out.println(ie.getMessage());
                    }
                }
            }
        } else {
            System.out.printf("Team %s does not exist.%n", input[1]);
        }
    }

    private static void addTeam(List<Team> teams, String teamName) {
        if (teams.stream().noneMatch(x -> x.getName().equals(teamName))) {
            try {
                Team team = new Team(teamName);
                teams.add(team);
            } catch (IllegalArgumentException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
}
