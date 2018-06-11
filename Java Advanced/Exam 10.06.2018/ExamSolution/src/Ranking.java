import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contestsWithPasswords = new LinkedHashMap<>();
        Map<String, Map<String, Long>> participantsWithContestsAndPoints = new LinkedHashMap<>();
        String command;
        while (!"end of contests".equalsIgnoreCase(command = reader.readLine())) {
            if (command.indexOf(":") == command.lastIndexOf(":")) {
                String[] contestAndPassword = command.split(":");
                contestsWithPasswords.put(contestAndPassword[0], contestAndPassword[1]);
            }
        }
        while (!"end of submissions".equalsIgnoreCase(command = reader.readLine())) {
            String[] participantData = command.split("=>");
            String contest = participantData[0];
            String password = participantData[1];
            String participantName = participantData[2];
            Long points = Long.parseLong(participantData[3]);
            if (contestsWithPasswords.containsKey(contest)) {
                if (contestsWithPasswords.get(contest).equals(password)) {
                    if (!participantsWithContestsAndPoints.containsKey(participantName)) {
                        participantsWithContestsAndPoints.putIfAbsent(participantName, new LinkedHashMap<>());
                    }
                    if (!participantsWithContestsAndPoints.get(participantName).containsKey(contest)) {
                        participantsWithContestsAndPoints.get(participantName).putIfAbsent(contest, 0L);
                    }
                    if(participantsWithContestsAndPoints.get(participantName).get(contest) < points){
                        participantsWithContestsAndPoints.get(participantName).put(contest, points);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        participantsWithContestsAndPoints.entrySet().stream()
                .sorted((x, y) -> Long.compare(y.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum(), x.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum()))
                .limit(1)
                .forEach(x -> sb.append(String.format("Best candidate is %s with total %d points.%n", x.getKey(), x.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum())));

        sb.append("Ranking:").append(System.lineSeparator());
        participantsWithContestsAndPoints.entrySet().stream()
                .filter(x -> x.getValue().entrySet().stream().mapToLong(Map.Entry::getValue).sum() > 0)
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(x -> {
                    sb.append(x.getKey()).append(System.lineSeparator());
                    x.getValue().entrySet().stream()
                            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(a -> sb.append(String.format("#  %s -> %d%n", a.getKey(), a.getValue())));
                });
        System.out.println(sb.toString());
    }
}
