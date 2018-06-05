import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> guests = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
        BiPredicate<String, String> startsWith = (prefix, str) -> {
            return str.startsWith(prefix);
        };
        BiPredicate<String, String> endsWith = (suffix, str) -> {
            return str.endsWith(suffix);
        };
        BiPredicate<Integer, String> isOfLength = (len, str) -> {
            return str.length() == len;
        };
        String command;
        while(!"Party!".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split("\\s+");
            switch (input[0]){
                case "Remove":
                    switch (input[1]){
                        case "StartsWith":
                            for (int i = 0; i < guests.size(); i++) {
                                if(startsWith.test(input[2], guests.get(i))){
                                    guests.remove(guests.get(i));
                                    i--;
                                }
                            }
                            break;
                        case "EndsWith":
                            for (int i = 0; i < guests.size(); i++) {
                                if(endsWith.test(input[2], guests.get(i))){
                                    guests.remove(guests.get(i));
                                    i--;
                                }
                            }
                            break;
                        case "Length":
                            for (int i = 0; i < guests.size(); i++) {
                                if(isOfLength.test(Integer.parseInt(input[2]), guests.get(i))){
                                    guests.remove(guests.get(i));
                                    i--;
                                }
                            }
                            break;
                    }
                    break;
                case "Double":
                    switch (input[1]){
                        case "StartsWith":
                            for (int i = 0; i < guests.size(); i++) {
                                if(startsWith.test(input[2], guests.get(i))){
                                    guests.add(i, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                        case "EndsWith":
                            for (int i = 0; i < guests.size(); i++) {
                                if(endsWith.test(input[2], guests.get(i))){
                                    guests.add(i, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                        case "Length":
                            for (int i = 0; i < guests.size(); i++) {
                                if(isOfLength.test(Integer.parseInt(input[2]), guests.get(i))){
                                    guests.add(i, guests.get(i));
                                    i++;
                                }
                            }
                            break;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();

        if(guests.isEmpty()){
            sb.append("Nobody is going to the party!");
        } else {
            for (String guest : guests) {
                sb.append(guest).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(" are going to the party!");
        }
        System.out.println(sb.toString());
    }
}
