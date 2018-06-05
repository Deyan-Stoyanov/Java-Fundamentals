import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] nums = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Comparator<Integer> comparator = (x, y) -> {
            if(x % 2 == 0 && y % 2 == 0){
                return Integer.compare(x, y);
            } else if(x % 2 == 0 && y % 2 != 0){
                return -1;
            } else if(x % 2 != 0 && y % 2 == 0){
                return 1;
            }
            return x - y;
        };
        Arrays.sort(nums, comparator);
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
