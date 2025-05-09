package org.example;
import java.util.ArrayList;


public class CardDeck {
    private ArrayList<Card> cards = new ArrayList<>();
    public CardDeck() {
        initialiseDeck();

    }
    public String generateSymbol(int value){
        return switch (value) {
            case 11 -> "J";
            case 12 -> "Q";
            case 13 -> "K";
            case 14 -> "A";
            default -> String.valueOf(value);
        };
    }
    public void initialiseDeck() {
        Suit[] suits = {Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS, Suit.SPADES};

        for (int value = 2; value <= 14; value++) {
            String symbol = generateSymbol(value);
            for (Suit suit : suits) {
                cards.add(new Card(suit, symbol, value));
            }
        }

    }
    public ArrayList<Card> getDeck() {
        return new ArrayList<>(cards);
    }
}
