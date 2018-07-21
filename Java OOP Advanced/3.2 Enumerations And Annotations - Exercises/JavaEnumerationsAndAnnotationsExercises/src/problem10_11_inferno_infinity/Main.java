package problem10_11_inferno_infinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new LinkedHashMap<>();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split(";");
            switch (tokens[0]){
                case "Create":
                    try {
                        weapons.put(tokens[2], new Weapon(tokens[1]));
                    } catch (Exception ignored){}
                    break;
                case "Add":
                    weapons.get(tokens[1]).addGem(tokens[3], Integer.parseInt(tokens[2]));
                    break;
                case "Remove":
                    weapons.get(tokens[1]).removeGem(Integer.parseInt(tokens[2]));
                    break;
                case "Print":
                    System.out.println(tokens[1] + ": " + weapons.get(tokens[1]).toString());
                    break;
            }
        }
        for (Map.Entry<String, Weapon> entry : weapons.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}
