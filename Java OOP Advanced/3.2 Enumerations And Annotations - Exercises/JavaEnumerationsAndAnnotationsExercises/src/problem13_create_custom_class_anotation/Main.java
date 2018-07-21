package problem13_create_custom_class_anotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while(!"END".equalsIgnoreCase(command = reader.readLine())) {
            switch (command){
                case "Author":
                    System.out.println(command + ": " + Weapons.class.getAnnotation(CustomAnnotation.class).author());
                    break;
                case "Description":
                    System.out.println("Class description: " + Weapons.class.getAnnotation(CustomAnnotation.class).description());
                    break;
                case "Reviewers":
                    System.out.println(command + ": " + String.join(", ", Weapons.class.getAnnotation(CustomAnnotation.class).reviewers()));
                    break;
                case "Revision":
                    System.out.println(command + ": " + Weapons.class.getAnnotation(CustomAnnotation.class).revision());
                    break;
            }
        }
    }
}
