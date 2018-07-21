package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Field[] fields = RichSoilLand.class.getDeclaredFields();
        Arrays.stream(fields).forEach(x -> x.setAccessible(true));
        String command;
        while (!"HARVEST".equalsIgnoreCase(command = reader.readLine())) {
            switch (command) {
                case "private":
                    Arrays.stream(fields).filter(x -> Modifier.isPrivate(x.getModifiers())).forEach(x -> System.out.printf("%s %s %s%n", Modifier.toString(x.getModifiers()), x.getType().getSimpleName(), x.getName()));
                    break;
                case "public":
                    Arrays.stream(fields).filter(x -> Modifier.isPublic(x.getModifiers())).forEach(x -> System.out.printf("%s %s %s%n", Modifier.toString(x.getModifiers()), x.getType().getSimpleName(), x.getName()));
                    break;
                case "protected":
                    Arrays.stream(fields).filter(x -> Modifier.isProtected(x.getModifiers())).forEach(x -> System.out.printf("%s %s %s%n", Modifier.toString(x.getModifiers()), x.getType().getSimpleName(), x.getName()));
                    break;
                case "all":
                    Arrays.stream(fields).forEach(x -> System.out.printf("%s %s %s%n", Modifier.toString(x.getModifiers()), x.getType().getSimpleName(), x.getName()));
                    break;
                default:
                    break;
            }
        }
    }
}
