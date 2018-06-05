import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class FindEvensAndOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] boundaries = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();
        BiFunction<int[], String, String> printNumbersInRange = (nums, str) -> {
            StringBuilder sb = new StringBuilder();
            switch (str){
                case "even":
                    for (int i = nums[0]; i <= nums[1]; i++) {
                        if(i % 2 == 0){
                            sb.append(i).append(" ");
                        }
                    }
                    break;
                case "odd":
                    for (int i = nums[0]; i <= nums[1]; i++) {
                        if(i % 2 != 0){
                            sb.append(i).append(" ");
                        }
                    }
                    break;
            }
            return sb.toString();
        };
        System.out.println(printNumbersInRange.apply(boundaries, command));
    }
}
