package java_advanced_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Set<FootballMatch> matches = new LinkedHashSet<>();
        while(!"Season End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("[\\s\\-:]+");
            matches.add(new FootballMatch(input[0], input[1], Integer.parseInt(input[3]), Integer.parseInt(input[4])));
            matches.add(new FootballMatch(input[1], input[0], Integer.parseInt(input[4]), Integer.parseInt(input[3])));
        }
        String[] teamsToLookFor = reader.readLine().split(", ");
        for (String s : teamsToLookFor) {
            matches.stream()
                    .filter(x -> x.getHomeTeam().equalsIgnoreCase(s))
                    .sorted(Comparator.comparing(x -> x.awayTeam))
                    .forEach(x -> System.out.printf("%s - %s -> %s:%s%n", x.homeTeam, x.awayTeam, x.homeResult, x.awayResult));
        }
    }

    static class FootballMatch{
        private String homeTeam;
        private String awayTeam;
        private int homeResult;
        private int awayResult;

        public FootballMatch(String homeTeam, String awayTeam, int homeResult, int awayResult) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.homeResult = homeResult;
            this.awayResult = awayResult;
        }

        public FootballMatch() {
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
        }

        public String getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
        }

        public int getHomeResult() {
            return homeResult;
        }

        public void setHomeResult(int homeResult) {
            this.homeResult = homeResult;
        }

        public int getAwayResult() {
            return awayResult;
        }

        public void setAwayResult(int awayResult) {
            this.awayResult = awayResult;
        }
    }
}
