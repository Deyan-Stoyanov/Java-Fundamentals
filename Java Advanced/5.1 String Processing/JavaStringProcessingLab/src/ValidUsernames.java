import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        List<String> occurencies = new ArrayList<>();
        while (!"END".equalsIgnoreCase(command = reader.readLine())){
            if(command.matches("^[a-zA-Z0-9_\\-]{3,16}$")){
                occurencies.add("valid");
            } else {
                occurencies.add("invalid");
            }
        }
        if(occurencies.contains("valid")){
            for (String s : occurencies) {
                System.out.println(s);
            }
        }
    }
}
