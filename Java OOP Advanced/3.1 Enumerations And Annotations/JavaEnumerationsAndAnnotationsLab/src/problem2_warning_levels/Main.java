package problem2_warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Logger logger = new Logger(reader.readLine());
        String command;
        while (!"END".equals(command = reader.readLine())){
            String[] tokens = command.split(":\\s");
            logger.addMessage(tokens[0], tokens[1]);
        }
        for (Message message : logger.getMessages()) {
            System.out.println(message.toString());
        }
    }
}
