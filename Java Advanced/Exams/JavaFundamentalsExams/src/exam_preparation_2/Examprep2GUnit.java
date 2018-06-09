package exam_preparation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Examprep2GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Set<String>>> database = new LinkedHashMap<>();
        String command;
        while(!"It's testing time!".equalsIgnoreCase(command = reader.readLine())) {
            if(command.matches("[A-Z][a-zA-Z0-9]+\\s\\|\\s[A-Z][a-zA-Z0-9]+\\s\\|\\s[A-Z][a-zA-Z0-9]+")){
                List<String> input =  Arrays.stream(command.split("[\\s|]+")).map(String::trim).map(String::valueOf).collect(Collectors.toList());
                if(!database.containsKey(input.get(0))){
                    database.put(input.get(0), new LinkedHashMap<>());
                }
                if(!database.get(input.get(0)).containsKey(input.get(1))){
                    database.get(input.get(0)).putIfAbsent(input.get(1), new LinkedHashSet<>());
                }
                database.get(input.get(0)).get(input.get(1)).add(input.get(2));
            }
        }
        StringBuilder sb = new StringBuilder();
        database.entrySet().stream()
                .sorted((clas1, clas2) -> {
                    if(clas2.getValue().values().stream().mapToInt(Set::size).sum() == clas1.getValue().values().stream().mapToInt(Set::size).sum()){
                        if(clas1.getValue().keySet().size() == clas2.getValue().keySet().size()){
                            return clas1.getKey().compareTo(clas2.getKey());
                        }
                        return clas1.getValue().keySet().size() - clas2.getValue().keySet().size();
                    }
                    return clas2.getValue().values().stream().mapToInt(Set::size).sum() - clas1.getValue().values().stream().mapToInt(Set::size).sum();
                }).forEach(x -> {
                    sb.append(x.getKey()).append(":").append(System.lineSeparator());
                    x.getValue().entrySet().stream().sorted((method1, method2) -> {
                        if(method2.getValue().size() == method1.getValue().size()){
                            return method1.getKey().compareTo(method2.getKey());
                        }
                        return method2.getValue().size() - method1.getValue().size();
                    }).forEach(y -> {
                        sb.append("##").append(y.getKey()).append(System.lineSeparator());
                        y.getValue().stream().sorted((test1, test2) -> {
                            if(test1.length() == test2.length()){
                                return test1.compareTo(test2);
                            }
                            return test1.length() - test2.length();
                        }).forEach(z -> sb.append("####").append(z).append(System.lineSeparator()));
                    });
        });
        System.out.println(sb.toString());
    }
}
