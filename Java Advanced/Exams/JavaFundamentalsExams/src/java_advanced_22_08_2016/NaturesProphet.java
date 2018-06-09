package java_advanced_22_08_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NaturesProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix =  new int[dimensions[0]][dimensions[1]];
        String command;
        while(!"Bloom Bloom Plow".equalsIgnoreCase(command = reader.readLine())) {
            int[] nums = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = nums[0];
            int col = nums[1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(i == row || j == col){
                        matrix[i][j]++;
                    }
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
