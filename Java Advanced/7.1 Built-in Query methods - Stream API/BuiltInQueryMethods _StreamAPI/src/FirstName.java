import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class FirstName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> names = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(TreeSet::new));

        Set<String> letters = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(HashSet::new));

        Optional<String> name = names.stream()
                .filter(x -> letters.stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toCollection(HashSet::new))
                        .contains(Character.toString(x.charAt(0)).toLowerCase()))
                .findFirst();

        if (name.isPresent()) {
            System.out.println(name.get());
        } else {
            System.out.println("No match");
        }
    }
}
