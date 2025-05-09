package org.example;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame {
    CardDeck deck = new CardDeck();

    ArrayList<Card> originalDeck = deck.getDeck();
    public Card dealCard(){
        if (originalDeck.isEmpty()) {
            throw new IllegalStateException("No more cards to deal.");
        }
        Card firstCard = originalDeck.get(0);
        System.out.println(originalDeck.get(0));
        originalDeck.remove(0);
        return firstCard;
    }
    public ArrayList<Card> shuffleDeck(){

        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random RANDOM = new Random();
        for(int i=0; i<originalDeck.size(); i++){
            int randomIndex = RANDOM.nextInt(shuffledDeck.size() + 1);
            shuffledDeck.add(randomIndex, originalDeck.get(i));
        }

        return shuffledDeck;
    }
    public ArrayList<Card> sortDeck() {
        ArrayList<Card> sortedDeck = new ArrayList<>(shuffleDeck());

        Collections.sort(sortedDeck, new Comparator<Card>() {
            @Override
            public int compare(Card c1, Card c2) {
                return Integer.compare(c1.value, c2.value);
            }
        });

        return sortedDeck;
    }
    public ArrayList<Card> sortDeckIntoSuits() {

        ArrayList<Card> sortedIntoSuitsDeck = new ArrayList<>(originalDeck);
        Collections.sort(sortedIntoSuitsDeck, Comparator.comparing(c -> c.suit));
        return sortedIntoSuitsDeck;
        };



}

