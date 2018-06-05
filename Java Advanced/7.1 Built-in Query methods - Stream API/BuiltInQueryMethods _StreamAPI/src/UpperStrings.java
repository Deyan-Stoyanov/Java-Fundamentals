import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UpperStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .map(String::toUpperCase)
                .forEach(x -> sb.append(x).append(" "));
        System.out.println(sb.toString());
    }
}