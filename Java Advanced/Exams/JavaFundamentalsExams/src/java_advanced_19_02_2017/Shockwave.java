package java_advanced_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        String command;
        while(!"Here We Go".equalsIgnoreCase(command = reader.readLine())) {
            int[] nums = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int i = Math.max(0, nums[0]); i <= Math.min(matrix.length - 1, nums[2]); i++) {
                for (int j = Math.max(0, nums[1]); j <= Math.min(matrix[i].length - 1, nums[3]); j++) {
                    matrix[i][j]++;
                }
            }
        }
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
