import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int dividor = Integer.parseInt(reader.readLine());
        BiFunction<int[], Integer, List<Integer>> reverseAndFilter = (numbers, n) -> {
            List<Integer> list = new ArrayList<>();
            for (int i = numbers.length - 1; i >= 0; i--) {
                if(numbers[i] % n != 0){
                    list.add(numbers[i]);
                }
            }
            return list;
        };
        List<Integer> result = reverseAndFilter.apply(nums, dividor);
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
