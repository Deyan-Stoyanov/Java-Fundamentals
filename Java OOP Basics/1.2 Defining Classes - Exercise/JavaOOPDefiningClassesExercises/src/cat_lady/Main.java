package cat_lady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Cat> cats = new LinkedHashSet<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] input = command.split(" ");
            switch (input[0]){
                case "Siamese":
                    Cat siamese = new Siamese(input[1], Double.parseDouble(input[2]));
                    cats.add(siamese);
                    break;
                case "Cymric":
                    Cat cymric = new Cymric(input[1], Double.parseDouble(input[2]));
                    cats.add(cymric);
                    break;
                case "StreetExtraordinaire":
                    Cat streetCat = new StreetExtraordinaire(input[1], Double.parseDouble(input[2]));
                    cats.add(streetCat);
                    break;
            }
        }
        command = reader.readLine();
        for (Cat cat : cats) {
            if(cat.getName().equals(command)){
                System.out.println(cat.toString());
            }
        }
    }
}
