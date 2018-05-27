import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new HashMap<>();
        String command;
        while (!"search".equalsIgnoreCase(command = reader.readLine())){
            String[] data = command.split("-");
            phoneBook.put(data[0], data[1]);
        }
        while(!"stop".equalsIgnoreCase(command = reader.readLine())) {
            if(phoneBook.containsKey(command)){
                System.out.println(command + " -> " + phoneBook.get(command));
            } else {
                System.out.println("Contact " + command + " does not exist.");
            }
        }
    }
}
