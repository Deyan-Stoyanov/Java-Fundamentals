import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Pair<String, List<Integer>>> students = new ArrayList<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            List<Integer> grades = Arrays.stream(input).filter(x -> x.matches("[0-9]")).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
            students.add(new Pair<>(input[0] + " " + input[1], grades));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> {
                    int count = 0;
                    for (Integer integer : x.getValue()) {
                        if(integer <= 3){
                            count++;
                        }
                    }
                    return count >= 2;
                }).forEach(x -> sb.append(x.getKey()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }
}
