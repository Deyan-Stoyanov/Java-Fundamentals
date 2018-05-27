import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> emails = new LinkedHashMap<>();
        String command;
        while(!"stop".equalsIgnoreCase(command = reader.readLine())) {
            if(!emails.containsKey(command)){
                emails.put(command, reader.readLine());
            }
        }
        for (Map.Entry<String, String> email : emails.entrySet()) {
            if(!email.getValue().matches(".*\\.(com|us|uk)")){
                System.out.println(email.getKey() + " -> " + email.getValue());
            }
        }
    }
}
