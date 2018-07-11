package problem10_tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Tuple<String, String> nameAndAddress = new CustomTuple<>();
        Tuple<String, Integer> nameAndBeerCapacity = new CustomTuple<>();
        Tuple<Integer, Double> integerAndDouble = new CustomTuple<>();
        String[] personData = reader.readLine().split("\\s+");
        String[] beerData = reader.readLine().split("\\s+");
        String[] numberData = reader.readLine().split("\\s+");
        nameAndAddress.put((personData[0] + " " + personData[1]), personData[2]);
        nameAndBeerCapacity.put(beerData[0], Integer.parseInt(beerData[1]));
        integerAndDouble.put(Integer.parseInt(numberData[0]), Double.parseDouble(numberData[1]));
        System.out.println(nameAndAddress.toString());
        System.out.println(nameAndBeerCapacity.getKey() + " -> " + nameAndBeerCapacity.getValue());
        System.out.println(integerAndDouble.toString());
    }
}
