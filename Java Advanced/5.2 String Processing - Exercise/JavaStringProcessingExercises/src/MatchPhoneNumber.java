import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while(!"end".equalsIgnoreCase(command = reader.readLine())) {
            if(command.matches("\\+359([\\s-])2\\1[0-9]{3}\\1[0-9]{4}")){
                System.out.println(command);
            }
        }
    }
}
