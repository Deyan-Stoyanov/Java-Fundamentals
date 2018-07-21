package problem3_4_cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Card card = null;
        try {
            card = new Card(reader.readLine(), reader.readLine());
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
        if(card != null){
            System.out.println(card.toString());
        }
    }
}
