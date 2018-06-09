package java_advanced_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        long sum = 0;
        int temp = 0;
        int sequence = 0;
        for (int i = 0; i < input.length; i++) {
            String value = input[i].substring(0, input[i].length() - 1);
            String type = input[i].substring(input[i].length() - 1);
            int powerOfCard = getValue(value);
            temp += powerOfCard;
            sequence++;
            if(i == input.length - 1){
                sum += (temp * sequence);
            } else {
                String nextType = input[i + 1].substring(input[i + 1].length() - 1);
                if(!type.equalsIgnoreCase(nextType)){
                    sum += (temp * sequence);
                    temp = 0;
                    sequence = 0;
                }
            }
        }
        System.out.println(sum);
    }

    private static int getValue(String value) {
        int powerOfCard = 0;
        switch (value){
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                powerOfCard = Integer.parseInt(value);
                break;
            case "J":
                powerOfCard = 12;
                break;
            case "Q":
                powerOfCard = 13;
                break;
            case "K":
                powerOfCard = 14;
                break;
            case "A":
                powerOfCard = 15;
                break;
        }
        return powerOfCard;
    }
}
