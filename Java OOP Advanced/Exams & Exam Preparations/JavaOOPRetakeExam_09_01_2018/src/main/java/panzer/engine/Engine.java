package panzer.engine;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.util.Config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        while(true) {
            String command = reader.readLine();
            if(command.contains("Vehicle") || command.contains("Part")){
                command = "add" + command;
            }
            command = command.replaceFirst(String.valueOf(command.charAt(0)), String.valueOf(command.charAt(0)).toLowerCase());
            List<String> tokens = Arrays.stream(command.split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
            String commandName = tokens.get(0);
            Method method = this.manager.getClass().getDeclaredMethod(commandName, List.class);
            method.setAccessible(true);
            String result = (String) method.invoke(this.manager, (Object) tokens);
            this.writer.println(result);
            if(tokens.get(0).equalsIgnoreCase(Config.TERMINATE_MESSAGE)){
                break;
            }
        }

    }
}
