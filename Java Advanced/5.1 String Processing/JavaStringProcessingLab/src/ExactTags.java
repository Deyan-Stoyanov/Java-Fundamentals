import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExactTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        Pattern pattern = Pattern.compile("<[/]?[^<>]+>");
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            Matcher matcher = pattern.matcher(command);
            while (matcher.find()){
                System.out.println(matcher.group());
            }
        }
    }
}
