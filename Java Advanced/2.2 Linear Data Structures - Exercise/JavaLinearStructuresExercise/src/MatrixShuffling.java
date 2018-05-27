import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];
        fillMatrix(reader, matrix, dimensions);
        String input;
        while(!"END".equals(input = reader.readLine())){
            String[] commands = input.split("\\s+");
            if(!commands[0].equalsIgnoreCase("swap") || commands.length != 5){
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(commands[1]);
            int col1 = Integer.parseInt(commands[2]);
            int row2 = Integer.parseInt(commands[3]);
            int col2 = Integer.parseInt(commands[4]);
            if(row1 >= dimensions[0] || row2 >= dimensions[0] || col1 >= dimensions[1] || col2 >= dimensions[1]){
                System.out.println("Invalid input!");
                continue;
            }
            swap(matrix, row1, row2, col1, col2);
            printMatrix(dimensions, matrix);
        }
    }

    private static void printMatrix(int[] dimesions, String[][] matrix) {
        for (int i = 0; i < dimesions[0]; i++) {
            for (int j = 0; j < dimesions[1]; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(String[][] matrix, int row1, int row2, int col1, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static void fillMatrix(BufferedReader reader, String[][] matrix, int[] dimensions) throws IOException {
        for (int i = 0; i < dimensions[0]; i++) {
            String[] strings = reader.readLine().split("\\s+");
            for (int j = 0; j < dimensions[1]; j++) {
                matrix[i][j] = strings[j];
            }
        }
    }
}
