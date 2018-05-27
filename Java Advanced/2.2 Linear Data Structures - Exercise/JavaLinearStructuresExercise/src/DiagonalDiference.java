import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDiference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[][] matrix = new long[n][n];
        fillMatrix(matrix, n, reader);
        long firstSum = 0;
        long secondSum = 0;
        System.out.println(difference(firstSum, secondSum, n, matrix));
    }

    private static long difference(long firstSum, long secondSum, int n, long[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    firstSum += matrix[i][j];
                } if(j == n - i - 1){
                    secondSum += matrix[i][j];
                }
            }
        }
        return Math.abs(firstSum - secondSum);
    }

    private static void fillMatrix(long[][] matrix, int n, BufferedReader reader) throws IOException {
        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nums[j];
            }
        }
    }
}
