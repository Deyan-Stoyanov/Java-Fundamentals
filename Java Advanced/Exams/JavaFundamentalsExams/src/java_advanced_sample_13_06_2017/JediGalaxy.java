package java_advanced_sample_13_06_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[nums[0]][nums[1]];
        long k = -1;
        for (int i = 0; i < nums[0]; i++) {
            for (int j = 0; j < nums[1]; j++) {
                matrix[i][j] = ++k;
            }
        }
        String command;
        long sum = 0;
        while (!"Let the Force be with you".equals(command = reader.readLine())) {
            int[] ivoStart = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilStart = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            while (evilStart[0] > 0 && evilStart[1] > 0 && ivoStart[0] > 0 && ivoStart[1] < nums[1] - 1) {
                evilStart[0]--;
                evilStart[1]--;
                ivoStart[0]--;
                ivoStart[1]++;
                if (evilStart[0] < nums[0] && evilStart[1] < nums[1] && ivoStart[0] < nums[0] && ivoStart[1] >= 0) {
                    if(!(ivoStart[0] == evilStart[0] && ivoStart[1] == evilStart[1])){
                        sum += matrix[ivoStart[0]][ivoStart[1]];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
