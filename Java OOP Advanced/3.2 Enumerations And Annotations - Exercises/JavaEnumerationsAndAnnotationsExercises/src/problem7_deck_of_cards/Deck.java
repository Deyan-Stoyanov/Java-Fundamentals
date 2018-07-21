package problem7_deck_of_cards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void generateCards() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank.name(), cardSuit.name());
                this.cards.add(card);
            }
        }
    }

    public Iterable<Card> getCards() {
        return this.cards.stream().sorted(new CardComparator()).collect(Collectors.toCollection(ArrayList::new));
    }
}
