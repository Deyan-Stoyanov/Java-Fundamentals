package problem3_generic_swap_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Box<String> box = new Box();
        for (int i = 0; i < n; i++) {
            box.add(reader.readLine());
        }
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        box.swap(box.list, nums[0], nums[1]);
        System.out.println(box.toString());
    }
}
