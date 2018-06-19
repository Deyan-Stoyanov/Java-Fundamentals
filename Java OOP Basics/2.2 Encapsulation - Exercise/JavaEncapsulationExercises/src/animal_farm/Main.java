package animal_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Chicken chicken = null;
        try {
            chicken = new Chicken(reader.readLine(), Integer.parseInt(reader.readLine()));
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
        if(chicken != null){
            System.out.println(chicken);
        }
    }
}
