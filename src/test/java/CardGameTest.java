import org.example.Card;
import org.example.CardDeck;
import org.example.CardGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    private CardGame game;
    public CardDeck deck = new CardDeck();
    private ArrayList<Card> testDeck;
    @BeforeEach
    public void setUp() {
        game = new CardGame();
       testDeck = deck.getDeck();
    }

    @Test
    public void dealCard_returns_one_card() {
        Card output = game.dealCard();
        assertNotNull(output);
        assertEquals(Card.class, output.getClass());
    }

    @Test
    public void dealCard_removes_card_from_deck() {
        Card firstCard = game.dealCard();
        Card secondCard = game.dealCard();
        assertNotEquals(firstCard, secondCard);
    }

    @Test
    public void shuffleDeck_returns_same_size_array_after_shuffling(){
        ArrayList<Card> output = game.shuffleDeck();
        assertEquals(output.size(), testDeck.size());
    }
}
