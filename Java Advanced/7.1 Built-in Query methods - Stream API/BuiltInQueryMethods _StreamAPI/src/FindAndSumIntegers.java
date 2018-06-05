import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;

public class FindAndSumIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OptionalInt sum = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(x -> !x.isEmpty())
                .filter(x -> x.matches("[+\\-]?[0-9]+"))
                .mapToInt(Integer::valueOf)
                .reduce((x, y) -> x + y);
        if(sum.isPresent()){
            System.out.println(sum.getAsInt());
        } else {
            System.out.println("No match");
        }
    }
}
