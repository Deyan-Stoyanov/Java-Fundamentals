package core;

import contracts.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private CommandHandlerImpl commandHandler;

    public Engine(CommandHandlerImpl commandHandler)
    {
        this.commandHandler = commandHandler;
    }

    public Engine()
    {
        this.commandHandler = new CommandHandlerImpl();
    }

    public CommandHandler getCommandHandler;

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!"End".equals(line = reader.readLine()))
        {
            List<String> tokens = Arrays.asList(line.split("\\\\"));
            String name = tokens.get(0);
            List<String> parameters = tokens.stream().skip(1).collect(Collectors.toList());
            try {
                String commandResult = this.commandHandler.executeCommand(name, parameters);
                System.out.println(commandResult);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
