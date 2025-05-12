package com.pluralsight.blackjack;


import com.pluralsight.blackjack.models.Deck;
import com.pluralsight.blackjack.models.Player;

import java.util.Scanner;

public class App {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Get player names
            System.out.print("Enter name for Player 1: ");
            String player1Name = scanner.nextLine();
            System.out.print("Enter name for Player 2: ");
            String player2Name = scanner.nextLine();

            // Create players
            Player player1 = new Player(player1Name);
            Player player2 = new Player(player2Name);

            // Create and shuffle the deck
            Deck deck = new Deck();
            deck.shuffle();

            // Deal 2 cards to each player
            for (int i = 0; i < 2; i++) {
                player1.addCard(deck.deal());
                player2.addCard(deck.deal());
            }

            // Show hands
            System.out.println();
            player1.showHand();
            player2.showHand();

            // Determine winner
            int p1Score = player1.getScore();
            int p2Score = player2.getScore();

            System.out.println();
            if (p1Score > 21 && p2Score > 21) {
                System.out.println("Both players busted! No winner.");
            } else if (p1Score > 21) {
                System.out.println(player2.getName() + " wins! " + player1.getName() + " busted.");
            } else if (p2Score > 21) {
                System.out.println(player1.getName() + " wins! " + player2.getName() + " busted.");
            } else if (p1Score > p2Score) {
                System.out.println(player1.getName() + " wins!");
            } else if (p2Score > p1Score) {
                System.out.println(player2.getName() + " wins!");
            } else {
                System.out.println("It's a tie!");
            }

            scanner.close();
        }
    }

