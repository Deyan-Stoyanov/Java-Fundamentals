import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSubmatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++) {
            long[] row = Arrays.stream(reader.readLine().split(",\\s+")).mapToLong(Long::parseLong).toArray();
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = row[j];
            }
        }
        long[][] submatrix = new long[2][2];
        long bestSum = Long.MIN_VALUE;
        for (int i = 0; i < dimensions[0] - 1; i++) {
            for (int j = 0; j < dimensions[1] - 1; j++) {
                long sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];
                if(sum > bestSum){
                    bestSum = sum;
                    submatrix[0][0] = matrix[i][j];
                    submatrix[0][1] = matrix[i][j + 1];
                    submatrix[1][0] = matrix[i + 1][j];
                    submatrix[1][1] = matrix[i + 1][j + 1];
                }
            }
        }
        System.out.println(submatrix[0][0] + " " + submatrix[0][1]);
        System.out.println(submatrix[1][0] + " " + submatrix[1][1]);
        System.out.println(bestSum);
    }
}
