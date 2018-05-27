import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        fillMatrix(dimensions, matrix);
        printMatrix(dimensions, matrix);
    }

    private static void printMatrix(int[] dimesions, String[][] matrix) {
        for (int i = 0; i < dimesions[0]; i++) {
            for (int j = 0; j < dimesions[1]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[] dimesions, String[][] matrix) {
        for (char r = 'a'; r < 'a' + dimesions[0]; r++) {
            for (char c = 'a'; c < 'a' + dimesions[1]; c++) {
                matrix[r - 97][c - 97] = r + "" + Character.toString((char)(c + (r - 97))) + "" + r;
            }
        }
    }
}
