package org.example;

import java.util.ArrayList;

public class Snap extends CardGame{
    public Snap(){
        startGame();
    }
    public void startGame() {
        System.out.println("Welcome to Snap! :)");
        System.out.println("Press enter to begin the game");
        ArrayList<Card> newShuffledDeck = shuffleDeck();
        UserCommandRunner userCommandRunner = new UserCommandRunner();
        Player playerOne = new Player(1, true);
        Player playerTwo = new Player(2, false);
        int i = 1;
        userCommandRunner.runCommands();

        while (i < newShuffledDeck.size()) {
            Card current = newShuffledDeck.get(i);
            Card previous = newShuffledDeck.get(i - 1);
            System.out.println(current);
            if (!current.symbol.equals(previous.symbol)) {
                if (playerOne.isTurn) {
                    System.out.println("Player One's turn:");
                    playerOne.isTurn = false;
                    playerTwo.isTurn = true;
                } else if (playerTwo.isTurn) {
                    System.out.println("Player Two's Turn:");
                    playerTwo.isTurn = false;
                    playerOne.isTurn = true;
                }
                userCommandRunner.runCommands();
                i++;
            } else {
                if (playerOne.isTurn) {
                    System.out.println("Player One's turn:");
                } else if (playerTwo.isTurn) {
                    System.out.println("Player Two's Turn:");
                }
                userCommandRunner.runSnapCommands(playerOne, playerTwo);
                if (userCommandRunner.runEndCommands()) {
                    startGame();
                }
                break;
            }
        }
    }
}
