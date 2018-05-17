import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String bestPlayer = "";
        long bestScore =Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            long score = Long.parseLong(reader.readLine());
            char[] letters = name.toCharArray();
            for (char c:letters) {
                if(c % 2 == 0){
                    score += c;
                } else {
                    score -= c;
                }
            }
            if(score > bestScore){
                bestPlayer = name;
                bestScore = score;
            }
        }
        System.out.printf("The winner is %s - %d points%n", bestPlayer, bestScore);
    }
}
