import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
        Map<String, BiPredicate> predicates = new HashMap<>();
        String command;
        while(!"Print".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("[;]");
            BiPredicate<String, String> predicate = (x, y) -> true;
            switch (input[1]){
                case "Starts with":
                    predicate = String::startsWith;
                    break;
                case "Ends with":
                    predicate = String::endsWith;
                    break;
                case "Length":
                    predicate = (str, len) -> str.length() == Integer.parseInt(len);
                    break;
                case "Contains":
                    predicate = String::contains;
                    break;
            }
            switch (input[0]){
                case "Add filter":
                    predicates.putIfAbsent(input[1] + ";" +  input[2], predicate);
                    break;
                case "Remove filter":
                    predicates.entrySet().removeIf(x -> x.getKey().equalsIgnoreCase(input[1] + ";" + input[2]));
                    break;
            }
        }
        for (Map.Entry<String, BiPredicate> entry : predicates.entrySet()) {
            for (int i = 0; i < names.size(); i++) {
                if(entry.getValue().test(names.get(i), entry.getKey().substring(entry.getKey().indexOf(";") + 1))){
                    names.remove(i);
                    i--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ");
        }
        System.out.println(sb.toString());
    }
}
