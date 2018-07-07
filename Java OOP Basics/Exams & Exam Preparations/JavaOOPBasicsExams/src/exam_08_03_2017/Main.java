package exam_08_03_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        String command;
        while (!"Paw Paw Pawah".equalsIgnoreCase(command = reader.readLine())) {
            String[] data = command.split("[\\s|]+");
            switch (data[0]) {
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(data[1]);
                    break;
                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(data[1]);
                    break;
                case "RegisterDog":
                    animalCenterManager.registerDog(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                    break;
                case "RegisterCat":
                    animalCenterManager.registerCat(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                    break;
                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(data[1], data[2]);
                    break;
                case "Cleanse":
                    animalCenterManager.cleanse(data[1]);
                    break;
                case "Adopt":
                    animalCenterManager.adopt(data[1]);
                    break;
                case "RegisterCastrationCenter":
                    animalCenterManager.registerCastrationCenter(data[1]);
                    break;
                case "SendForCastration":
                    animalCenterManager.sendForCastration(data[1], data[2]);
                    break;
                case "Castrate":
                    animalCenterManager.castrate(data[1]);
                    break;
                case "CastrationStatistics":
                    animalCenterManager.castrationStatistics();
                    break;
            }
        }
        animalCenterManager.printStatistics();
    }
}
