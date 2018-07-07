package problem7_food_shortages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Buyer> buyers = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] buyerData = reader.readLine().split("\\s+");
            Buyer buyer = null;
            if(buyerData.length == 3){
                buyer = new Rebel(buyerData[0], Integer.parseInt(buyerData[1]), buyerData[2]);
            } else if(buyerData.length == 4){
                buyer = new Citizen(buyerData[0], Integer.parseInt(buyerData[1]), buyerData[2], buyerData[3]);
            }
            if(buyer != null && buyers.stream().noneMatch(x -> x.getName().equals(buyerData[0]))){
                buyers.add(buyer);
            }
        }
        String command;
        while(!"End".equalsIgnoreCase(command = reader.readLine())) {
            String finalCommand = command;
            buyers.stream().filter(x -> x.getName().equals(finalCommand)).limit(1).forEach(Buyer::buyFood);
        }
        System.out.println(buyers.stream().mapToInt(Buyer::getFood).sum());
    }
}
