import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Long> creaturesAndGenomes = new LinkedHashMap<>();
        String pattern = "^[!@#$?a-zA-Z]+=[0-9]+--[0-9]+<<[a-zA-Z]+$";
        Queue<String> genomes = new ArrayDeque<>();
        String command;
        while(!"Stop!".equalsIgnoreCase(command = reader.readLine())) {
            if(command.matches(pattern)){
                genomes.offer(command);
            }
        }
        while(!genomes.isEmpty()) {
            String currentGenome = genomes.remove();
            String genomeName = currentGenome.substring(0, currentGenome.indexOf("="));
            Integer genomeLength = Integer.parseInt(currentGenome.substring(currentGenome.indexOf("=") + 1, currentGenome.indexOf("--")));
            Long genomeSize = Long.parseLong(currentGenome.substring(currentGenome.indexOf("--") + 2, currentGenome.indexOf("<<")));
            String animal = currentGenome.substring(currentGenome.indexOf("<<") + 2);
            Integer actualSize = 0;
            for (int i = 0; i < genomeName.length(); i++) {
                if(Character.toString(genomeName.charAt(i)).matches("[a-zA-Z]")){
                    actualSize++;
                }
            }
            if(actualSize.equals(genomeLength)){
                if(!creaturesAndGenomes.containsKey(animal)){
                    creaturesAndGenomes.put(animal, 0L);
                }
                creaturesAndGenomes.put(animal, creaturesAndGenomes.get(animal) + genomeSize);
            }
        }
        StringBuilder sb = new StringBuilder();
        creaturesAndGenomes.entrySet().stream()
                .sorted((x, y) -> Long.compare(y.getValue(), x.getValue()))
                .forEach(x -> {
                    sb.append(x.getKey()).append(" has genome size of ").append(x.getValue()).append(System.lineSeparator());
                });
        System.out.println(sb.toString());
    }
}
