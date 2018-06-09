package java_advanced_22_08_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> roses = new LinkedHashMap<>();
        String command;
        while(!"Icarus, Ignite!".equalsIgnoreCase(command = reader.readLine())) {
            if(command.matches("Grow <[A-Z][a-z]+> <[a-zA-Z0-9]+> [0-9]+")){
                String[] input = command.split("[\\s<>]+");
                String region = input[1];
                String colour = input[2];
                Long amount = Long.parseLong(input[3]);
                if(!roses.containsKey(region)){
                    roses.putIfAbsent(region, new LinkedHashMap<>());
                }
                if(!roses.get(region).containsKey(colour)){
                    roses.get(region).putIfAbsent(colour, 0L);
                }
                roses.get(region).put(colour, roses.get(region).get(colour) + amount);
            }
        }
        StringBuilder sb = new StringBuilder();
        roses.entrySet().stream()
                .sorted((x, y) -> {
                    if(y.getValue().values().stream().mapToLong(v -> v).sum() == x.getValue().values().stream().mapToLong(v -> v).sum()){
                        return x.getKey().compareTo(y.getKey());
                    }
                    return Long.compare(y.getValue().values().stream().mapToLong(v -> v).sum(), x.getValue().values().stream().mapToLong(v -> v).sum());
                }).forEach(x -> {
                    sb.append(x.getKey()).append(System.lineSeparator());
                    x.getValue().entrySet().stream()
                            .sorted((a, b) -> {
                                if(a.getValue().equals(b.getValue())){
                                    return a.getKey().compareTo(b.getKey());
                                }
                                return Long.compare(a.getValue(), b.getValue());
                            }).forEach(y -> sb.append(String.format("*--%s | %d%n", y.getKey(), y.getValue())));
        });
        System.out.println(sb.toString());
    }
}
