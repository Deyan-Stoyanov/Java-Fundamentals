import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("[a-z0-9]+([.\\-_][a-z0-9]+)*@([a-z]+([a-z\\-])*)(\\.([a-z]+([a-z\\-])*))+");
        String command;
        while (!"end".equalsIgnoreCase(command = reader.readLine())){
            if(command.endsWith(".")){
                command = command.substring(0, command.length() - 1);
            }
            String[] entries = command.split("[\\s\\$\\^,]+");
            for (String entry : entries) {
                if(entry.matches(pattern.toString())){
                    System.out.println(entry);
                }
            }
        }
    }
}
