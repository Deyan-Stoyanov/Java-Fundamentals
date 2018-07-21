package problem7_deck_of_cards;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
    public CardComparator() {
    }

    @Override
    public int compare(Card firstCard, Card secondCard) {
        if(Integer.compare(firstCard.getSuit().ordinal(), secondCard.getSuit().ordinal()) == 0){
            return Integer.compare(firstCard.getRank().ordinal(), secondCard.getRank().ordinal());
        }
        return Integer.compare(firstCard.getSuit().ordinal(), secondCard.getSuit().ordinal());
    }
}
