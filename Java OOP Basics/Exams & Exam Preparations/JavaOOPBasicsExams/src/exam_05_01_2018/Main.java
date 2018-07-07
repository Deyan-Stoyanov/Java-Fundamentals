package exam_05_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] colonyData = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Colony colony = new Colony(colonyData[0], colonyData[1]);
        String command;
        while (!"end".equalsIgnoreCase(command = reader.readLine())) {
            String[] data = command.split("\\s+");
            switch (data[0]) {
                case "insert":
                    insertColonist(colony, data);
                    break;
                case "remove":
                    removeFromColony(colony, data);
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(data[1]));
                    break;
                case "potential":
                    System.out.println("potential: " + colony.getPotential());
                    break;
                case "capacity":
                    System.out.println(colony.getCapacity());
                    break;
                case "family":
                    System.out.println(colony.getFamily(data[1]));
                    break;
                default:
                    break;
            }
        }
    }

    private static void removeFromColony(Colony colony, String[] data) {
        switch (data[1]) {
            case "family":
                colony.removeFamily(data[2]);
                break;
            case "colonist":
                colony.removeColonist(data[2], data[3]);
                break;
            default:
                break;
        }
    }

    private static void insertColonist(Colony colony, String[] data) {
        Colonist colonist = null;
        switch (data[1]) {
            case "exam_05_01_2018.SoftwareEngineer":
                colonist = new SoftwareEngineer(data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                break;
            case "exam_05_01_2018.HardwareEngineer":
                colonist = new HardwareEngineer(data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                break;
            case "exam_05_01_2018.GeneralPractitioner":
                colonist = new GeneralPractitioner(data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6]);
                break;
            case "exam_05_01_2018.Surgeon":
                colonist = new Surgeon(data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), data[6]);
                break;
            default:
                break;
        }
        if (colonist != null) {
            try {
                colony.addColonist(colonist);
            } catch (IllegalArgumentException ie){
                System.out.println(ie.getMessage());
            }
        }
    }
}
