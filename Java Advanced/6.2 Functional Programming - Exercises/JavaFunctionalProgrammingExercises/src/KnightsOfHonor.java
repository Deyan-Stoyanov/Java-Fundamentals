import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Consumer<String[]> printNamesAsSir = x -> Arrays.stream(x).forEach(s -> System.out.println("Sir " + s));
        printNamesAsSir.accept(input);
    }
}
