import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceSeparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern patternString =Pattern.compile("^.*\\s" + reader.readLine() + "\\s.*$");
        String text = reader.readLine();
        Pattern pattern = Pattern.compile("[A-Z]([a-z]+[,\\\\\"\\-\\s]*[a-z]*)*[.!?]\\s?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String entry = matcher.group();
            Matcher matcher1 = patternString.matcher(entry);
            if (matcher1.find()){
                System.out.println(entry);
            }
        }
    }
}
