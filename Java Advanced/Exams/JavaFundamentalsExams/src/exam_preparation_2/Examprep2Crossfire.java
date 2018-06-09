package exam_preparation_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Examprep2Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<List<Long>> matrix = new ArrayList<>(dimensions[0]);
        long n = 0;
        for (int i = 0; i < dimensions[0]; i++) {
            matrix.add(new ArrayList<>(dimensions[1]));
            for (int j = 0; j < dimensions[1]; j++) {
                matrix.get(i).add(++n);
            }
        }
        String command;
        while (!"Nuke it from orbit".equalsIgnoreCase(command = reader.readLine())){
            int[] nums = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x = nums[0];
            int y = nums[1];
            int radius = nums[2];
            for (int i = Math.max(x - radius, 0); i <= Math.min(x + radius, matrix.size() - 1); i++) {
                for (int j = Math.max(y - radius, 0); j <= Math.min(y + radius, matrix.get(i).size() - 1); j++) {
                    if(i == x || j == y){
                        matrix.get(i).set(j, 0L);
                    }
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if(matrix.get(i).get(j) == 0){
                        matrix.get(i).remove(j);
                        j--;
                    }
                }
                if(matrix.get(i).isEmpty()){
                    matrix.remove(i);
                    i--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sb.append(matrix.get(i).get(j));
                sb.append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
