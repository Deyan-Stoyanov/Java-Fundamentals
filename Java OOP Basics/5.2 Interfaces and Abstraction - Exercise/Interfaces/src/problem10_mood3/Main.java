package problem10_mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = reader.readLine().split("[\\s|]+");
        GameObject gameObject = null;
        switch (command[1]){
            case "Demon":
                gameObject = new Demon(command[0], Integer.parseInt(command[3]), command[2]);
                break;
            case "Archangel":
                gameObject = new Archangel(command[0], Integer.parseInt(command[3]), command[2]);
                break;
        }
        if(gameObject != null){
            System.out.println(gameObject);
        }
    }
}
