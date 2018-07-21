package problem1_card_suit;

public class Main {

    public static void main(String[] args) {
	    CardSuit[] suits = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit suit : suits) {
            System.out.println(suit.toString());
        }
    }
}
