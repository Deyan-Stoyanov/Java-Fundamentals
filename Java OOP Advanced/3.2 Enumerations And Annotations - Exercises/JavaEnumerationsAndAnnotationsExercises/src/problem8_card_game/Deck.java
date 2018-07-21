package problem8_card_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        this.generateCards();
    }

    public void generateCards() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                Card card = new Card(cardRank.name(), cardSuit.name());
                this.cards.add(card);
            }
        }
    }

    public Card takeCard(String cardName){
        if(this.cards.stream().noneMatch(x -> x.getName().equalsIgnoreCase(cardName))){
            throw new IllegalArgumentException("Card is not in the deck.");
        }
        Card card = this.cards.stream().filter(x -> x.getName().equalsIgnoreCase(cardName)).findFirst().get();
        this.cards.removeIf(x -> x.getName().equalsIgnoreCase(cardName));
        return card;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }
}
