import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blurAmount = Integer.parseInt(reader.readLine());
        int[] matrixDimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[matrixDimensions[0]][matrixDimensions[1]];
        for (int i = 0; i < matrixDimensions[0]; i++) {
            int[] row = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < row.length; j++) {
                matrix[i][j] = row[j];
            }
        }
        int[] blurPositions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = Math.max(0, (blurPositions[0] - 1)); i <= Math.min(matrixDimensions[0] - 1, (blurPositions[0] + 1)); i++) {
            for (int j = Math.max(0, (blurPositions[1] - 1)); j <= Math.min(matrixDimensions[1] - 1, (blurPositions[1] + 1)); j++) {
                matrix[i][j] += blurAmount;
            }
        }
        for (int i = 0; i < matrixDimensions[0]; i++) {
            for (int j = 0; j < matrixDimensions[1]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
