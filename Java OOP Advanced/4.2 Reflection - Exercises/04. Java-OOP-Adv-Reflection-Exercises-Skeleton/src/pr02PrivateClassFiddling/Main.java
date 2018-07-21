package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Constructor constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt integer = (BlackBoxInt) constructor.newInstance();
        Field field = integer.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);
        String command;
        while (!"END".equalsIgnoreCase(command = reader.readLine())) {
            String[] tokens = command.split("[\\s_]+");
            String methodName = tokens[0];
            int number = Integer.parseInt(tokens[1]);
            Method currentMethod = integer.getClass().getDeclaredMethod(methodName, int.class);
            currentMethod.setAccessible(true);
            currentMethod.invoke(integer, number);
            System.out.println(field.get(integer));
        }
    }
}