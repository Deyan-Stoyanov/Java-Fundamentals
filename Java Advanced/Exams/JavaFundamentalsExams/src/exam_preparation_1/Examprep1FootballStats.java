package exam_preparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Examprep1FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<FootballMatch> footballMatches = new LinkedHashSet<>();
        String command;
        StringBuilder sb = new StringBuilder();
        while (!"Season End".equalsIgnoreCase(command = reader.readLine())){
            List<String> input = Arrays.stream(command.split("[\\s\\-:]+")).filter(x -> !x.isEmpty() && !x.equalsIgnoreCase("result")).collect(Collectors.toList());
            FootballMatch firstMatch = new FootballMatch(input.get(0), input.get(1), Integer.parseInt(input.get(2)), Integer.parseInt(input.get(3)));
            FootballMatch secondMatch = new FootballMatch(input.get(1), input.get(0), Integer.parseInt(input.get(3)), Integer.parseInt(input.get(2)));
            footballMatches.add(firstMatch);
            footballMatches.add(secondMatch);
        }
        String[] output = reader.readLine().split(", ");
        for (String s : output) {
            footballMatches.stream()
                    .filter(x -> x.homeTeam.equalsIgnoreCase(s))
                    .sorted(Comparator.comparing(x -> x.awayTeam))
                    .forEach(x -> {
                        sb.append(String.format("%s - %s -> %s:%s%n", x.homeTeam, x.awayTeam, x.homeResult, x.awayResult));
                    });
        }
        System.out.println(sb.toString());

    }

    private static class FootballMatch{
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
