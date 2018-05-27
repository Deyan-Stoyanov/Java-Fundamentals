import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = nums[0];
        int m = nums[1];
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(reader.readLine()));
        }
        for (Integer i : firstSet) {
            if(secondSet.contains(i)){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
