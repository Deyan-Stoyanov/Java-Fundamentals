import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        long[][] matrix = new long[dimensions[0]][dimensions[1]];
        fillMatrix(reader, matrix, dimensions);
        long bestSum = Long.MIN_VALUE;
        long[][] bestMatrix = new long[3][3];
        findBestMatrix(matrix, bestMatrix, dimensions, bestSum);
        printBestMatrix(bestMatrix);
    }

    private static void printBestMatrix(long[][] bestMatrix) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findBestMatrix(long[][] matrix, long[][] bestMatrix, int[] dimensions, long bestSum) {
        for (int i = 0; i < dimensions[0] - 2; i++) {
            for (int j = 0; j < dimensions[1] - 2; j++) {
                long sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i+1][j] + matrix[i+1][j + 1] + matrix[i+1][j + 2] + matrix[i+2][j] + matrix[i+2][j + 1] + matrix[i+2][j + 2];
                if(sum > bestSum){
                    bestSum = sum;
                    bestMatrix[0][0] = matrix[i][j];
                    bestMatrix[0][1] = matrix[i][j + 1];
                    bestMatrix[0][2] = matrix[i][j + 2];
                    bestMatrix[1][0] = matrix[i + 1][j];
                    bestMatrix[1][1] = matrix[i + 1][j + 1];
                    bestMatrix[1][2] = matrix[i + 1][j + 2];
                    bestMatrix[2][0] = matrix[i + 2][j];
                    bestMatrix[2][1] = matrix[i + 2][j + 1];
                    bestMatrix[2][2] = matrix[i + 2][j + 2];
                }
            }
        }
        System.out.println("Sum = " + bestSum);
    }

    private static void fillMatrix(BufferedReader reader, long[][] matrix, int[] dimensions) throws IOException {
        for (int i = 0; i < dimensions[0]; i++) {
            int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = nums[j];
            }
        }
    }
}
