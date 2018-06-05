import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] bannedWords = reader.readLine().split("[,\\s]+");
        String text = reader.readLine();
        for (String word : bannedWords) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append("*");
            }
            text = text.replaceAll(word, sb.toString());
        }
        System.out.println(text);
    }
}
