package exam_preparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Examprep1Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[dimensions[0]][dimensions[1]];
        String command;
        while(!"Here We Go".equalsIgnoreCase(command = reader.readLine())) {
            int[] nums = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int leftX = nums[0];
            int leftY = nums[1];
            int rightX = nums[2];
            int rightY = nums[3];
            for (int i = Math.max(0, leftX); i <= Math.min(matrix.length - 1, rightX); i++) {
                for (int j = Math.max(0, leftY); j <=  Math.min(matrix[i].length - 1, rightY); j++) {
                    matrix[i][j]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
