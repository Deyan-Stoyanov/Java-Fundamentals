import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MelrahShake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String pattern = reader.readLine();
        while (!text.isEmpty() && text.contains(pattern) && text.lastIndexOf(pattern) != text.indexOf(pattern) && !pattern.isEmpty()){
            StringBuilder sb = new StringBuilder();
            text = text.replaceFirst(pattern, "");
            text = text.substring(0, text.lastIndexOf(pattern)) + text.substring(text.lastIndexOf(pattern) + pattern.length());
            System.out.println("Shaked it.");
            sb.append(pattern);
            pattern = sb.deleteCharAt(pattern.length() / 2).toString();
        }
        System.out.println("No shake.");
        System.out.println(text);
    }
}
