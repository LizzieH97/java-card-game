package org.example;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<String> symbols = new ArrayList<>();
    final int MAX_NUM = 14;
    final int MIN_NUM = 2;
    public static final Random RANDOM = new Random();
    public CardDeck() {
        initialiseDeck();

    }
    public String generateSymbol(int value){
        switch(value) {
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            case 14: return "A";
            default: return String.valueOf(value);
        }
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
