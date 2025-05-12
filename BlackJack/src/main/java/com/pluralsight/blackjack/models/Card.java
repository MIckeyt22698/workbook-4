package com.pluralsight.blackjack.models;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
    // only return the suit if the card is face up
        if (isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
    // only return the value if the card is face up
        if (isFaceUp) {
    // this is the string value of the card
    // i.e. A, K, Q, J, 10, 9 ...
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (!isFaceUp) {
            return 0;
        }

        return switch (value) {
            case "A" -> 11;
            case "K", "Q", "J" -> 10;
            default -> {
                try {
                    yield Integer.parseInt(value); // for "2" to "10"
                } catch (NumberFormatException e) {
                    yield 0; // fallback in case of an unexpected value
                }
            }
        };
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}
