package callofduty.engine;

import callofduty.interfaces.Engine;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.util.Config;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private MissionManager manager;

    public EngineImpl(InputReader reader, OutputWriter writer, MissionManager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    public void run() {
        while(true) {
            String[] commands = reader.readLine().split("\\s+");
            String commandName = commands[0];
            List<String> tokens = Arrays.stream(commands).skip(1).collect(Collectors.toCollection(ArrayList::new));
            String result = "";
            try {
                Method method = this.manager.getClass().getDeclaredMethod(commandName.toLowerCase(), List.class);
                method.setAccessible(true);
                result = (String) method.invoke(this.manager, (Object) tokens);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            this.writer.println(result);
            if(commandName.equalsIgnoreCase(Config.OVER_COMMAND)){
                break;
            }
        }
    }
}
