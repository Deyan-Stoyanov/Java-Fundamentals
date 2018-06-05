import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalDouble;

public class AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OptionalDouble average = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();
        if(average.isPresent()){
            System.out.printf("%.2f%n", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
