import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> guests = new TreeSet<>();
        String command;
        while(!"PARTY".equalsIgnoreCase(command = reader.readLine())){
            guests.add(command);
        }
        while(!"END".equalsIgnoreCase(command = reader.readLine())){
            guests.remove(command);
        }
        System.out.println(guests.size());
        for (String s:guests) {
            System.out.println(s);
        }
    }
}
