import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] matrix = new char[8][32];
        for (int i = 0; i < 8; i++) {
            int number = Integer.parseInt(reader.readLine());
            matrix[i] = String.format("%32s", Integer.toBinaryString(number)).replace(" ", "0").toCharArray();
        }
        int count = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 31; j++) {
                if(matrix[i - 1][j - 1] == '1' && matrix[i - 1][j] == '0' && matrix[i - 1][j + 1] == '1' &&
                        matrix[i][j - 1] == '0' && matrix[i][j] == '1' && matrix[i][j + 1] == '0' &&
                        matrix[i + 1][j - 1] == '1' && matrix[i + 1][j] == '0' && matrix[i + 1][j + 1] == '1'){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
