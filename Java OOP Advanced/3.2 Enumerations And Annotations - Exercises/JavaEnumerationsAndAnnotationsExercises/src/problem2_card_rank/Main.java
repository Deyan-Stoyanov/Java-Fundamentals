package problem2_card_rank;

public class Main {
    public static void main(String[] args) {
        CardRank[] ranks = CardRank.values();
        System.out.println("Card Ranks:");
        for (CardRank rank : ranks) {
            System.out.println(rank.toString());
        }
    }
}
