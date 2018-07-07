package problem6_birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Birthable> allVisitors = new ArrayList<>();
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String[] visitorData = command.split("\\s+");
            Birthable birthable = null;
            switch (visitorData[0]){
                case "problem6_birthday_celebrations.Citizen":
                    birthable = new Citizen(visitorData[1], Integer.parseInt(visitorData[2]), visitorData[3], visitorData[4]);
                    break;
                case "problem6_birthday_celebrations.Pet":
                    birthable = new Pet(visitorData[1], visitorData[2]);
                    break;
            }
            if(birthable != null){
                allVisitors.add(birthable);
            }
        }
        String year = reader.readLine();
        for (Birthable b : allVisitors) {
            if(b.getBirthDate().endsWith(year)) {
                System.out.println(b.getBirthDate());
            }
        }
    }
}
