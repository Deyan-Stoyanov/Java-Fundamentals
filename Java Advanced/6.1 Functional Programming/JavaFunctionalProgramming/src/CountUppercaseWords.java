import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[\\s]+");
        Predicate<String> checkUppercase = x -> Character.toString(x.charAt(0)).toUpperCase().equals(Character.toString(x.charAt(0)));
        List<String> upperCasedWords = new ArrayList<>();
        Arrays.stream(input).filter(checkUppercase::test).forEach(upperCasedWords::add);
        Consumer<List<String>> printWords = x -> x.forEach(System.out::println);
        System.out.println(upperCasedWords.size());
        printWords.accept(upperCasedWords);
    }
}
