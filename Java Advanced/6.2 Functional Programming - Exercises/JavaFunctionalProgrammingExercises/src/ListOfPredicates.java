import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        BiPredicate<Integer, int[]> isDivisibleBy = (number, dividers) -> {
            for (int divider : dividers) {
                if (number % divider != 0) {
                    return false;
                }
            }
            return true;
        };
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(isDivisibleBy.test(i, nums)){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
