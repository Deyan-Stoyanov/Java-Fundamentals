import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurences {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Pattern pattern = Pattern.compile(reader.readLine().toLowerCase());
        Matcher matcher = pattern.matcher(text.toLowerCase());
        int count = 0;
        while (matcher.find()){
            count++;
        }
        System.out.println(count);
    }
}
