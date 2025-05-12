package com.pluralsight.blackjack.models;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card) {
        card.flip(); // Flip to face-up when added
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getScore() {
        int score = 0;
        int aces = 0;

        for (Card card : hand) {
            String value = card.getValue();

            if (value.equals("A")) {
                score += 11;
                aces++;
            } else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
                score += 10;
            } else {
                score += Integer.parseInt(value);
            }
        }

        // Adjust for aces if score is over 21
        while (score > 21 && aces > 0) {
            score -= 10;
            aces--;
        }

        return score;
    }

    public void showHand() {
        System.out.print(name + "'s hand: ");
        for (Card card : hand) {
            System.out.print(card.getValue() + " of " + card.getSuit() + ", ");
        }
        System.out.println("Score: " + getScore());
    }
}
