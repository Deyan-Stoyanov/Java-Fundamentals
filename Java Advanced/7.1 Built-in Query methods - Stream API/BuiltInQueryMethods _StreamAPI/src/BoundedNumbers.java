import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(x -> x >= Arrays.stream(bounds).min().getAsInt() && x <= Arrays.stream(bounds).max().getAsInt())
                .collect(Collectors.toCollection(ArrayList::new));
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString());
    }
}
