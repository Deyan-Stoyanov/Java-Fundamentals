import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitWordsByCasing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = Arrays.stream(reader.readLine().split("[,;:.!()'/\\[\\]\\s]+")).collect(Collectors.toList());
        List<String> lowerCased = new ArrayList<>();
        List<String> middleCased = new ArrayList<>();
        List<String> upperCased = new ArrayList<>();
        for (String s:strings) {
            if(s.toLowerCase().equals(s)){
                lowerCased.add(s);
            } else if(s.toUpperCase().equals(s)){
                upperCased.add(s);
            } else {
                middleCased.add(s);
            }
        }
        StringBuilder lower = new StringBuilder();
        lower.append("Lower-case: ");
        for (String l:lowerCased) {
            lower.append(l).append(", ");
        }
        StringBuilder middle = new StringBuilder();
        middle.append("Mixed-case: ");
        for (String m:middleCased) {
            middle.append(m).append(", ");
        }
        StringBuilder upper = new StringBuilder();
        upper.append("Upper-case: ");
        for (String u:upperCased) {
            upper.append(u).append(", ");
        }
        System.out.println(lower.toString().substring(0, lower.lastIndexOf(",")));
        System.out.println(middle.toString().substring(0, middle.lastIndexOf(",")));
        System.out.println(upper.toString().substring(0, upper.lastIndexOf(",")));
    }
}
