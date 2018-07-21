package problem8_card_game;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    public CardComparator() {
    }

    @Override
    public int compare(Card firstCard, Card secondCard) {
        return secondCard.getPower() - firstCard.getPower();
    }
}
