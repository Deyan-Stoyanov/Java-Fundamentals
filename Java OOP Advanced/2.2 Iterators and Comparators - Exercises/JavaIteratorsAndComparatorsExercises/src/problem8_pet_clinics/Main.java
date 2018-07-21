package problem8_pet_clinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Clinic> clinics = new LinkedHashMap<>();
        Map<String, Pet> pets = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    switch (tokens[1]) {
                        case "Pet":
                            Pet pet = new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                            pets.put(pet.getName(), pet);
                            break;
                        case "Clinic":
                            try {
                                Clinic clinic = new Clinic(tokens[2], Integer.parseInt(tokens[3]));
                                clinics.put(clinic.getName(), clinic);
                            } catch (UnsupportedOperationException uoe) {
                                System.out.println(uoe.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add":
                    if (clinics.containsKey(tokens[2])) {
                        System.out.println(clinics.get(tokens[2]).add(pets.get(tokens[1])));
                    }
                    break;
                case "Release":
                    System.out.println(clinics.get(tokens[1]).release());
                    break;
                case "HasEmptyRooms":
                    System.out.println(clinics.get(tokens[1]).hasMoreRooms());
                    break;
                case "Print":
                    switch (tokens.length) {
                        case 2:
                            if (clinics.containsKey(tokens[1])) {
                                clinics.get(tokens[1]).print();
                            }
                            break;
                        case 3:
                            if (clinics.containsKey(tokens[1])) {
                                clinics.get(tokens[1]).print(Integer.parseInt(tokens[2]));
                            }
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
