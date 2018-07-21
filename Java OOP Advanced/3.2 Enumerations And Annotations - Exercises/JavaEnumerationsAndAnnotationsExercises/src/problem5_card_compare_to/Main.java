package problem5_card_compare_to;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Card firstCard = null;
        Card secondCard = null;
        try {
            firstCard = new Card(reader.readLine(), reader.readLine());
            secondCard = new Card(reader.readLine(), reader.readLine());
        } catch (IllegalArgumentException ie){
            System.out.println(ie.getMessage());
        }
        if(firstCard != null && secondCard != null){
            System.out.println(getWinningCard(firstCard, secondCard));
        }
    }

    private static String getWinningCard(Card firstCard, Card secondCard) {
        if(firstCard.compareTo(secondCard) >= 0){
            return firstCard.toString();
        }
        return secondCard.toString();
    }
}
