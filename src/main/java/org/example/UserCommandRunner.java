package org.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class UserCommandRunner {
    CardDeck deck = new CardDeck();
    ArrayList<Card> originalDeck = deck.getDeck();

    private Scanner scanner = new Scanner(System.in);

    public void runCommands() {
        String read = scanner.nextLine();
        if (!read.isEmpty())
            System.out.println("Sorry, there's some sort of error!");
    }

    public void runSnapCommands(Player playerOne, Player playerTwo) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> inputTask = () -> scanner.nextLine();
        Future<String> future = executor.submit(inputTask);

        try {
            String read = future.get(2, TimeUnit.SECONDS);
            if (read.isEmpty()) {
                System.out.println("You fool!!! That was a snap!!!");
            } else if (read.equalsIgnoreCase("snap")) {
                System.out.println("SNAP!!!");
                if (playerOne.isTurn) {

                    System.out.println("Well done Player One!!");
                    future.cancel(true);
                } else if (playerTwo.isTurn) {

                    System.out.println("Well done Player Two!");
                    future.cancel(true);
                } else {
                    System.out.println("What??? You lose!!");
                    future.cancel(true);
                }
            }
        } catch (TimeoutException e) {
            System.out.println("TOO SLOW!!!! AHA YOU LOSE!!!");
            future.cancel(true);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdownNow();
        }
    }
    public boolean runEndCommands() {
        System.out.println("Want to play again?");
        System.out.println("1. Yes please!");
        System.out.println("2. No thanks.");
        Scanner endScanner = new Scanner(System.in);
        String endRead = endScanner.nextLine();

        if (endRead.equals("1")) {
            return true;
        } else if (endRead.equals("2")) {
            System.out.println("Thanks, come again!");
            return false;
        } else {
            throw new IllegalArgumentException("Please enter 1 or 2");
        }
    }}

