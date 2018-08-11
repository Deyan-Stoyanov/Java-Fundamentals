package problem1_event_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        NameChangeListener handler = new Handler();
        Dispatcher dispatcher = new Dispatcher("dispatcher");
        dispatcher.addNameChangeListener(handler);
        String command;
        while (!"End".equalsIgnoreCase(command = reader.readLine())){
            NameChange nameChange = new NameChange(dispatcher, command);
            dispatcher.fireNameChangeEvent(nameChange);
        }
    }
}
