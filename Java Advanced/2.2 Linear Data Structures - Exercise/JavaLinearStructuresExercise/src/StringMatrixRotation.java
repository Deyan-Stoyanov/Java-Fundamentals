import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] command = reader.readLine().split("[\\(\\)\\s+]");
        List<String> input = new ArrayList<>();
        String line;
        int colNumber = 0;
        while (!"END".equalsIgnoreCase(line = reader.readLine())){
            input.add(line);
            if(line.length() > colNumber){
                colNumber = line.length();
            }
        }
        char[][] matrix = new char[input.size()][colNumber];
        int rowNumber = input.size();
        fillMatrix(reader, matrix, input, colNumber);
        int rotationDegrees = Integer.parseInt(command[1]);
        while(rotationDegrees >= 360){
            rotationDegrees -= 360;
        }
        switch (rotationDegrees){
            case 0:
                printMatrix(rowNumber, colNumber, matrix);
                break;
            case 90:
                rotateMatrixBy90Degrees(matrix, colNumber, rowNumber);
                break;
            case 180:
                rotateMatrixBy180Degrees(matrix, colNumber, rowNumber);
                break;
            case 270:
                rotateMatrixBy270Degrees(matrix, colNumber, rowNumber);
                break;
        }
    }

    private static void rotateMatrixBy270Degrees(char[][] matrix, int colNumber, int rowNumber) {
        char[][] tempResult = new char[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                tempResult[i][j] = matrix[rowNumber - i - 1][colNumber - j - 1];
            }
        }
        char[][] tempResult2 = new char[colNumber][rowNumber];
        for (int i = 0; i < colNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                tempResult2[colNumber - i - 1][j] = tempResult[j][i];
            }
        }
        char[][] result = new char[colNumber][rowNumber];
        for (int i = 0; i < colNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                result[i][j] = tempResult2[colNumber - i - 1][rowNumber - j - 1];
            }
        }
        printMatrix(colNumber, rowNumber, result);
    }

    private static void rotateMatrixBy180Degrees(char[][] matrix, int colNumber, int rowNumber) {
        char[][] result = new char[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                result[i][j] = matrix[rowNumber - i - 1][colNumber - j - 1];
            }
        }
        printMatrix(rowNumber, colNumber, result);
    }

    private static void rotateMatrixBy90Degrees(char[][] matrix, int colNumber, int rowNumber) {
        char[][] tempResult = new char[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                tempResult[i][j] = matrix[rowNumber - i - 1][colNumber - j - 1];
            }
        }
        char[][] result = new char[colNumber][rowNumber];
        for (int i = 0; i < colNumber; i++) {
            for (int j = 0; j < rowNumber; j++) {
                result[colNumber - i - 1][j] = tempResult[j][i];
            }
        }
        printMatrix(colNumber, rowNumber, result);
    }

    private static void printMatrix(int rowCount, int colCount, char[][] matrix){
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(BufferedReader reader, char[][] matrix, List<String> input, int matrixLength) throws IOException {
        for (int i = 0; i < input.size(); i++) {
            char[] chars = input.get(i).toCharArray();
            for (int j = 0; j < matrixLength; j++) {
                if(j >= chars.length){
                    matrix[i][j] = ' ';
                } else {
                    matrix[i][j] = chars[j];
                }
            }
        }
    }
}
