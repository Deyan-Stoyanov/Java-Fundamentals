package java_advanced_19_06_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class CubicsAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> meteors = new LinkedHashMap<>();
        String command;
        while (!"Count em all".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" -> ");
            if (!meteors.containsKey(input[0])) {
                meteors.putIfAbsent(input[0], new LinkedHashMap<>());
                meteors.get(input[0]).putIfAbsent("Black", 0L);
                meteors.get(input[0]).putIfAbsent("Red", 0L);
                meteors.get(input[0]).putIfAbsent("Green", 0L);
            }
            meteors.get(input[0]).put(input[1], meteors.get(input[0]).get(input[1]) + Long.parseLong(input[2]));
            for (Map.Entry<String, Map<String, Long>> entry : meteors.entrySet()) {
                while (entry.getValue().get("Green") >= 1000000) {
                    entry.getValue().put("Green", entry.getValue().get("Green") - 1000000);
                    entry.getValue().put("Red", entry.getValue().get("Red") + 1);
                }
                while (entry.getValue().get("Red") >= 1000000) {
                    entry.getValue().put("Red", entry.getValue().get("Red") - 1000000);
                    entry.getValue().put("Black", entry.getValue().get("Black") + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        meteors.entrySet().stream()
                .sorted((x, y) -> {
                    if (y.getValue().get("Black").equals(x.getValue().get("Black"))) {
                        if (x.getKey().length() == y.getKey().length()) {
                            return x.getKey().compareTo(y.getKey());
                        }
                        return x.getKey().length() - y.getKey().length();
                    }
                    return Long.compare(y.getValue().get("Black"), (x.getValue().get("Black")));
                }).forEach(x -> {
            sb.append(x.getKey()).append(System.lineSeparator());
            x.getValue().entrySet().stream()
                    .sorted((a, b) -> {
                        if (b.getValue().equals(a.getValue())) {
                            return a.getKey().compareTo(b.getKey());
                        }
                        return Long.compare(b.getValue(), a.getValue());
                    }).forEach(a -> {
                        sb.append(String.format("-> %s : %d%n", a.getKey(), a.getValue()));
            });
        });
        System.out.println(sb.toString());
    }
}
