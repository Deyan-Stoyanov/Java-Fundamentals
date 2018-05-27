import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, HashSet<String>> people = new LinkedHashMap<>();
        String command;
        while(!"JOKER".equalsIgnoreCase(command = reader.readLine())){
            String[] input = command.split(":");
            String player = input[0];
            HashSet<String> cards = Arrays.stream(input[1].split(",\\s+")).map(x -> x = x.trim()).collect(Collectors.toCollection(HashSet::new));
            if(!people.containsKey(player)){
                people.put(player, cards);
            } else {
                for (String c:cards) {
                    people.get(player).add(c);
                }
            }
        }
        for (Map.Entry<String, HashSet<String>> person : people.entrySet()) {
            long value = 0;
            for (String card:person.getValue()) {
                String points = card.substring(0, card.length() - 1);
                String power = card.substring(card.length() - 1);
                value += cardValue(points) * powerValue(power);
            }
            System.out.println(person.getKey() + ": " + value);
        }
    }

    private static Integer cardValue(String card){
        if(card.matches("[0-9]+")){
            return Integer.parseInt(card);
        } else {
            switch (card.toUpperCase()){
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                case "A":
                    return 14;
                    default:
                        return 0;
            }
        }
    }

    private static Integer powerValue(String power){
        switch (power.toUpperCase()){
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;
                default:
                    return 0;
        }
    }
}
