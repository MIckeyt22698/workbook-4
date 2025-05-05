package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        setRoomType(roomType);
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        updatePriceForWeekend();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType.toLowerCase();
        if (this.roomType.equals("king")) {
            this.price = 249.00;
        } else if (this.roomType.equals("double")) {
            this.price = 189.00;
        } else {
            throw new IllegalArgumentException("Invalid room type. Must be 'king' or 'double'.");
        }
        updatePriceForWeekend();
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
        updatePriceForWeekend();
    }

    public double getReservationTotal() {
        return price * numberOfNights;
    }


    private void updatePriceForWeekend() {
        if (roomType == null) return;

        if (isWeekend) {
            if (roomType.equals("king")) {
                this.price = 250.00 * 1.10;
            } else if (roomType.equals("double")) {
                this.price = 189.00 * 1.10;
            }
        } else {
            if (roomType.equals("king")) {
                this.price = 250.00;
            } else if (roomType.equals("double")) {
                this.price = 189.00;
            }
        }
    }
}
