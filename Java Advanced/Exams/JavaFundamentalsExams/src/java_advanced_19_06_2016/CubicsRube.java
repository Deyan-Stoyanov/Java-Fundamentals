package java_advanced_19_06_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubicsRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][][] cube = new int[n][n][n];
        List<String> hitCells = new ArrayList<>();
        String command;
        while(!"Analyze".equalsIgnoreCase(command = reader.readLine())) {
            int[] data = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            if(data[0] >= 0 && data[0] < n && data[1] >= 0 && data[1] < n && data[2] >= 0 && data[2] < n && !hitCells.contains(command.substring(0, command.lastIndexOf(" ")))){
                cube[data[0]][data[1]][data[2]] = data[3];
            }
            hitCells.add(command.substring(0, command.lastIndexOf(" ")));
        }
        long count = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(cube[i][j][k] == 0){
                        count++;
                    } else {
                        sum += cube[i][j][k];
                    }
                }
            }
        }
        System.out.println(sum);
        System.out.println(count);
    }
}
