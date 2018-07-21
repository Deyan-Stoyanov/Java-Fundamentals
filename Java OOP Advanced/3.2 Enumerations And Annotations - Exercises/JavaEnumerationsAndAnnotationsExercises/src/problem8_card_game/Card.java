package problem8_card_game;

public class Card implements Comparable<Card>{
    private CardSuit suit;
    private CardRank rank;

    public Card(String rank, String suit) {
        this.rank = Enum.valueOf(CardRank.class, rank);
        this.suit = Enum.valueOf(CardSuit.class, suit);
    }

    public CardSuit getSuit() {
        return this.suit;
    }

    public CardRank getRank() {
        return this.rank;
    }

    public String getName(){
        return this.rank.name() + " of " + this.suit.name();
    }

    public int getPower(){
        return this.rank.getPower() + this.suit.getPower();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int compareTo(Card card) {
        return this.getPower() - card.getPower();
    }
}
