import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> findMinNumber = x -> {
            int minNumber = Integer.MAX_VALUE;
            for (int i : x) {
                if(i < minNumber){
                    minNumber = i;
                }
            }
            return minNumber;
        };
        System.out.println(findMinNumber.apply(nums));
    }
}
