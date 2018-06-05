import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            sb.append(command);
        }
        String result = sb.toString();
        Pattern pattern = Pattern.compile("<a\\s+(.*\\s*)?href=[\"\']?([a-zA-Z0-9:/.]+)[\\s+\"\'>](.*)?</a>");
        Matcher matcher = pattern.matcher(result);
        while(matcher.find()) {
            String s = matcher.group();
            System.out.println(matcher.group(2));
        }
    }
}
