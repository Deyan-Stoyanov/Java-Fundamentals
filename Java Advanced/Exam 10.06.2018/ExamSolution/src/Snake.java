import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(", ");
        String[][] matrix = new String[n][n];
        long length = 1;
        long allFood = 0;
        int[] snakeIndices = new int[2];
        for (int i = 0; i < n; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = row[j];
                if (matrix[i][j].equalsIgnoreCase("s")) {
                    snakeIndices[0] = i;
                    snakeIndices[1] = j;
                } else if (matrix[i][j].equalsIgnoreCase("f")) {
                    allFood++;
                }
            }
        }
        boolean gameOver = false;
        for (String command : commands) {
            switch (command) {
                case "left":
                    if (snakeIndices[1] - 1 >= 0 && snakeIndices[1] - 1 < n) {
                        snakeIndices[1]--;
                    } else {
                        snakeIndices[1] = n - 1;
                    }
                    break;
                case "right":
                    if (snakeIndices[1] + 1 >= 0 && snakeIndices[1] + 1 < n) {
                        snakeIndices[1]++;
                    } else {
                        snakeIndices[1] = 0;
                    }
                    break;
                case "up":
                    if (snakeIndices[0] - 1 >= 0 && snakeIndices[0] - 1 < n) {
                        snakeIndices[0]--;
                    } else {
                        snakeIndices[0] = n - 1;
                    }
                    break;
                case "down":
                    if (snakeIndices[0] + 1 >= 0 && snakeIndices[0] + 1 < n) {
                        snakeIndices[0]++;
                    } else {
                        snakeIndices[0] = 0;
                    }
                    break;
            }
            if (matrix[snakeIndices[0]][snakeIndices[1]].equalsIgnoreCase("f")) {
                length++;
            } else if (matrix[snakeIndices[0]][snakeIndices[1]].equalsIgnoreCase("e")) {
                gameOver = true;
                break;
            }
            if (length == (allFood + 1)) {
                break;
            }
        }
        if (gameOver) {
            System.out.println("You lose! Killed by an enemy!");
        } else if ((allFood + 1) != length) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", allFood - length + 1);
        } else {
            System.out.printf("You win! Final snake length is %d%n", length);
        }
    }
}
