import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfMatrixElements {
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
        System.out.println(dimensions[0]);
        System.out.println(dimensions[1]);
        long sum = 0;
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}
