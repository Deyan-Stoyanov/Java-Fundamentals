package problem4_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("[\\s+,]+");
        Integer[] nums = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            nums[i] = Integer.parseInt(tokens[i]);
        }
        Lake<Integer> lake = new Lake<>(nums);
        System.out.println(String.join(", ", lake.jump().stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
