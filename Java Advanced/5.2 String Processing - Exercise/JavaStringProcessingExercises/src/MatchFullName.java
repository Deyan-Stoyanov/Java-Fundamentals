import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (!"end".equalsIgnoreCase(command = reader.readLine())){
            if(command.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$")){
                System.out.println(command);
            }
        }
    }
}
