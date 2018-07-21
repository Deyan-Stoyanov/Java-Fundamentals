package problem8_card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Card>> players = new LinkedHashMap<>();
        Deck deck = new Deck();
        String firstPlayerName= reader.readLine();
        String secondPlayerName= reader.readLine();
        players.put(firstPlayerName, new ArrayList<>());
        players.put(secondPlayerName, new ArrayList<>());
        addPlayerCards(reader, players, deck, firstPlayerName);
        addPlayerCards(reader, players, deck, secondPlayerName);
        String winner;
        String winningCard;
        if(players.get(firstPlayerName).stream().mapToInt(Card::getPower).max().getAsInt() >= players.get(secondPlayerName).stream().mapToInt(Card::getPower).max().getAsInt()){
            winner = firstPlayerName;
            winningCard = players.get(firstPlayerName).stream().sorted(new CardComparator()).map(Card::getName).findFirst().get();
        } else {
            winner = secondPlayerName;
            winningCard = players.get(secondPlayerName).stream().sorted(new CardComparator()).map(Card::getName).findFirst().get();
        }
        System.out.printf("%s wins with %s.", winner, winningCard);

    }

    private static void addPlayerCards(BufferedReader reader, Map<String, List<Card>> players, Deck deck, String firstPlayerName) throws IOException {
        while(players.get(firstPlayerName).size() < 5) {
            String cardName = reader.readLine();
            if(contains(cardName)){
                try {
                    players.get(firstPlayerName).add(deck.takeCard(cardName));
                }catch (IllegalArgumentException ie){
                    System.out.println(ie.getMessage());
                }
            } else {
                System.out.println("No such card exists.");
            }
        }
    }

    public static boolean contains(String value) {
        boolean rankExists = false;
        boolean suitExists = false;
        String rank = value.split("\\s+")[0];
        String suit = value.split("\\s+")[2];
        for (CardSuit s : CardSuit.values()) {
            if (s.name().equals(suit)) {
                suitExists = true;
                break;
            }
        }
        for (CardRank r : CardRank.values()) {
            if (r.name().equals(rank)) {
                rankExists = true;
                break;
            }
        }
        if(rankExists && suitExists){
            return true;
        }
        return false;
    }
}
