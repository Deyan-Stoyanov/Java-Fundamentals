import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String first = input[0];
        String second = input[1];
        long result = 0;
        if(first.length() == second.length()){
            for (int i = 0; i < first.length(); i++) {
                result += (first.toCharArray()[i] * second.toCharArray()[i]);
            }
        } else if(first.length() < second.length()){
            for (int i = 0; i < first.length(); i++) {
                result += (first.charAt(i) * second.charAt(i));
            }
            for (int i = first.length(); i < second.length(); i++) {
                result += second.charAt(i);
            }
        } else {
            for (int i = 0; i < second.length(); i++) {
                result += (first.charAt(i) * second.charAt(i));
            }
            for (int i = second.length(); i < first.length(); i++) {
                result += first.charAt(i);
            }
        }
        System.out.println(result);
    }
}
