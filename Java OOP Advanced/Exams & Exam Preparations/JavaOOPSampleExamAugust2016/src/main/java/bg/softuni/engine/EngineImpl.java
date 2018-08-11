package bg.softuni.engine;

import bg.softuni.interfaces.Engine;
import bg.softuni.interfaces.InputReader;
import bg.softuni.interfaces.Manager;
import bg.softuni.interfaces.OutputWriter;
import bg.softuni.util.Const;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EngineImpl implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public EngineImpl(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() throws IOException {
        String command;
        while(!Const.FINAL_COMMAND.equalsIgnoreCase(command = reader.readLine())) {
            String result = "";
            String[] input = command.split("[:@\\s]+");
            String methodName = input[0];
            methodName = methodName.replaceFirst(String.valueOf(input[0].charAt(0)), String.valueOf(input[0].charAt(0)).toLowerCase());
            String[] inputParams = new String[input.length - 1];
            for (int i = 1; i < input.length; i++) {
                inputParams[i - 1] = input[i];
            }
            try {
                Method method = this.manager.getClass().getDeclaredMethod(methodName, String[].class);
                method.setAccessible(true);
                result = (String) method.invoke(this.manager, (Object) inputParams);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            this.writer.writeLine(result);
        }
    }
}
