package problem11_threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Threeuple<String, String, String> nameAndAddress = new CustomThreeuple<>();
        Threeuple<String, Integer, Boolean> nameAndBeerCapacity = new CustomThreeuple<>();
        Threeuple<String, Double, String> integerAndDouble = new CustomThreeuple<>();
        String[] personData = reader.readLine().split("\\s+");
        String[] beerData = reader.readLine().split("\\s+");
        String[] bankData = reader.readLine().split("\\s+");
        nameAndAddress.put((personData[0] + " " + personData[1]), personData[2], personData[3]);
        nameAndBeerCapacity.put(beerData[0], Integer.parseInt(beerData[1]), beerData[2].equalsIgnoreCase("drunk"));
        integerAndDouble.put(bankData[0], Double.parseDouble(bankData[1]), bankData[2]);
        System.out.println(nameAndAddress.toString());
        System.out.println(nameAndBeerCapacity.toString());
        System.out.println(integerAndDouble.toString());
    }
}
