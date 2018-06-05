import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Pair<String, String>> students = new ArrayList<>();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            students.add(new Pair<>(input[0], input[1]));
        }
        StringBuilder sb = new StringBuilder();
        students.stream()
                .filter(x -> x.getKey().compareTo(x.getValue()) < 0)
                .forEach(x -> sb.append(x.getKey()).append(" ").append(x.getValue()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }
}
