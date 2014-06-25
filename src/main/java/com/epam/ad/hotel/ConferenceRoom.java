package com.epam.ad.hotel;

import java.math.BigDecimal;

public class ConferenceRoom extends Room {

    private int square;
    private int seatsNumber;

    public ConferenceRoom(Builder builder) {
        square = builder.square;
        seatsNumber = builder.seatsNumber;
        price = builder.price;

    }

    @Override
    public BigDecimal getCurrentCost() {
        return BigDecimal.ZERO;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public int getNumberOfSeats() {
        return seatsNumber;
    }

    public void setNumberOfSeats(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Override
    public String toString() {
        return "ConferenceRoom{" +
                "price='" + price + '\'' +
                "square=" + square +
                ", seatsNumber=" + seatsNumber +
                '}' + "\n";
    }

    public static class Builder {
        private int square = 0;
        private int seatsNumber = 0;
        private BigDecimal price = BigDecimal.ZERO;

        public Builder size(int val) {
            square = val;
            return this;
        }

        public Builder numberOfSeats(int val) {
            seatsNumber = val;
            return this;
        }

        public Builder initialCost(BigDecimal val) {
            price = val;
            return this;
        }

        public ConferenceRoom build() {
            return new ConferenceRoom(this);
        }
    }

}
