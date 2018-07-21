package problem7_deck_of_cards;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.generateCards();
        deck.getCards().forEach(System.out::println);
    }
}
