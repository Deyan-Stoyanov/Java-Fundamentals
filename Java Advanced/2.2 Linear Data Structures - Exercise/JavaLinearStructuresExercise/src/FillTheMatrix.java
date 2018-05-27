import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {

    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = reader.readLine().split(",\\s+");
	    int n = Integer.parseInt(input[0]);
	    String type = input[1];
	    long[][] matrix = new long[n][n];
	    int number = 1;
	    switch (type.toUpperCase()){
            case "A":
                firstSort(n, number, matrix);
                break;
            case "B":
                secondSort(n, matrix, number);
                break;
                default:
                    break;
        }
        getMatrix(n, matrix);
    }

    private static void getMatrix(int n, long[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void firstSort(int n, int number, long[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = number;
                number++;
            }
        }
    }

    private static void secondSort(int n, long[][] matrix, int number) {
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0){
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = number;
                    number++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[j][i] = number;
                    number++;
                }
            }
        }
    }
}
