package problem6_animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidClassException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (!"Beast!".equalsIgnoreCase(command = reader.readLine())) {
            String[] animalData = reader.readLine().split("\\s+");
            String animalName = animalData[0];
            Integer animalAge = Integer.parseInt(animalData[1]);
            String gender = animalData[2];
            Animal animal = null;
            try {
                switch (command.toLowerCase()) {
                    case "cat":
                        animal = new Cat(animalName, animalAge, gender);
                        break;
                    case "dog":
                        animal = new Dog(animalName, animalAge, gender);
                        break;
                    case "frog":
                        animal = new Frog(animalName, animalAge, gender);
                        break;
                    case "kitten":
                        animal = new Kitten(animalName, animalAge, gender);
                        break;
                    case "tomcat":
                        animal = new Tomcat(animalName, animalAge, gender);
                        break;
                    default:
                        throw new InvalidInputException();
                }
            } catch (InvalidInputException iie) {
                System.out.println(iie.getMessage());
            }
            if (animal != null) {
                System.out.println(animal);
            }
        }
    }
}
