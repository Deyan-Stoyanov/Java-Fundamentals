import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Function<String, int[]> parseNumbers = x -> Arrays.stream(x.split("[,\\s]+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> getSumOfArray = x -> Arrays.stream(x).sum();
        Function<int[], String> printResult = x -> "Count = " + x.length + System.lineSeparator() + "Sum = " + getSumOfArray.apply(x);
        System.out.println(printResult.apply(parseNumbers.apply(input)));
    }
}
