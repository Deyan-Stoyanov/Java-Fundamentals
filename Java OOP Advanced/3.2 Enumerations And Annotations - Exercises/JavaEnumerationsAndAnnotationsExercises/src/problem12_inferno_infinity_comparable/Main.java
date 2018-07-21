package problem12_inferno_infinity_comparable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapons> weapons = new LinkedHashMap<>();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split(";");
            switch (tokens[0]){
                case "Create":
                    try {
                        weapons.put(tokens[2], Enum.valueOf(Weapons.class, tokens[1]));
                    } catch (Exception ignored){}
                    break;
                case "Add":
                    weapons.get(tokens[1]).addGem(tokens[3], Integer.parseInt(tokens[2]));
                    break;
                case "Remove":
                    weapons.get(tokens[1]).removeGem(Integer.parseInt(tokens[2]));
                    break;
                case "Compare":
                    if(weapons.get(tokens[1]).compareTo(weapons.get(tokens[2])) >= 0){
                        System.out.println(tokens[1] + ": " + weapons.get(tokens[1]).toString());
                    } else {
                        System.out.println(tokens[2] + ": " + weapons.get(tokens[2]).toString());
                    }
                    break;
                case "Print":
                    System.out.println(tokens[1] + ": " + weapons.get(tokens[1]).toString());
                    break;
            }
        }
//        for (Map.Entry<String, Weapons> entry : weapons.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
//        }
    }
}
