package org.example;

public class Card {
    protected Suit suit;
    protected String symbol;
    protected int value;
    public Card(Suit suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return symbol + " of " + suit;
    }
}
