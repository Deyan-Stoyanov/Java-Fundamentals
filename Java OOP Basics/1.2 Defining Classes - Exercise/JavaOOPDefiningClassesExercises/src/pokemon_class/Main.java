package pokemon_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while(!"Tournament".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" ");
            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            long pokemonHealth = Long.parseLong(input[3]);
            if(!trainers.containsKey(trainerName)){
                trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            }
            trainers.get(trainerName).getPokemons().add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
        }
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            for (Trainer trainer : trainers.values()) {
                trainer.increaseBadges(command);
            }
        }
        StringBuilder sb = new StringBuilder();
        trainers.values().stream()
                .sorted((x, y) -> Long.compare(y.getNumberOfBadges(), x.getNumberOfBadges()))
                .forEach(x -> sb.append(x.getName()).append(" ").append(x.getNumberOfBadges()).append(" ").append(x.getPokemons().size()).append(System.lineSeparator()));
        System.out.println(sb.toString());
    }
}
