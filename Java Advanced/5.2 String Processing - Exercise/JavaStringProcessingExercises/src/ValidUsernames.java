import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.stream(reader.readLine().split("[\\s()\\\\/]+")).filter(x -> x.matches("[a-zA-Z][a-zA-Z0-9_]{2,24}")).collect(Collectors.toList());
        int bestSum = 0;
        String longestUsernames = "";
        for (int i = 0; i < input.size() - 1; i++) {
            if((input.get(i).length() + input.get(i + 1).length()) > bestSum){
                bestSum = (input.get(i).length() + input.get(i + 1).length());
                longestUsernames = String.format("%s%n%s", input.get(i), input.get(i + 1));
            }
        }
        System.out.println(longestUsernames);
    }
}
