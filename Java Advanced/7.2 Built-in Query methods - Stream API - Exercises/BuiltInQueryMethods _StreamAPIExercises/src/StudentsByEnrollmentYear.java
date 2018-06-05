import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StudentsByEnrollmentYear {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Integer>> students = new LinkedHashMap<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            List<Integer> grades = Arrays.stream(input).filter(x -> x.matches("[0-9]")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
            students.putIfAbsent(input[0], grades);
        }
        StringBuilder sb = new StringBuilder();
        students.entrySet().stream()
                .filter(x -> x.getKey().matches("[0-9]{4}14") || x.getKey().matches("[0-9]{4}15"))
                .forEach(x -> {
                    x.getValue().forEach(y -> sb.append(y).append(" "));
                    sb.append(System.lineSeparator());
                });
        System.out.println(sb.toString());
    }
}
