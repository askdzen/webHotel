package com.epam.ad.hotel;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Random;

;

public class ResidentRoom extends Room {

    public static final int SINGLEROOM_PRICE = 500;
    public static final int DOUBLEROOM_PRICE = 700;
    public static final int TRIPLEROOM_PRICE = 1000;
    public static final Comparator<ResidentRoom> RESIDENT_ROOM_COMPARATOR = new randomNumberComparator();
    private Boolean breakfast;
    private Boolean wiFi;
    private Type type;

    public ResidentRoom(Builder builder) {
        price = builder.price;
        type = builder.type;
        breakfast = builder.breakfast;
        wiFi = builder.wiFi;
        randomNumber = builder.randomNumber;
    }

    @Override
    public String toString() {
        return "ResidentRoom{" +
                "roomNumber='" + randomNumber + '\'' +
                "price='" + price + '\'' +
                "Type='" + type + '\'' +
                ", breakfast=" + breakfast +
                ", wiFi=" + wiFi + "}" +
                "\n";
    }

    @Override
    public BigDecimal getCurrentCost() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public Boolean getWiFi() {
        return wiFi;
    }

    public void setWiFi(Boolean wiFi) {
        this.wiFi = wiFi;
    }


    static enum Type {SINGLEROOM, DOOBLEROOM, TRIPLEROOM}

    public static class Builder {
        private BigDecimal price = BigDecimal.ZERO;
        private Boolean breakfast = false;
        private Boolean wiFi = false;
        private Type type;
        private String randomNumber = getRandomNumber();

        public Builder randomNumber(String val) {
            randomNumber = val;
            return this;
        }

        public Builder roomType(Type val) {
            type = val;
            return this;
        }

        public Builder initialCost(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder breakfast(Boolean val) {
            breakfast = val;
            return this;
        }

        public Builder wiFi(Boolean val) {
            wiFi = val;
            return this;
        }

        public ResidentRoom build() {
            return new ResidentRoom(this);
        }

        public String getRandomNumber() {
            Random random = new Random();
            int randomFloor = random.nextInt(Room.FLOOR.length);
            int randomRoom = random.nextInt(Room.ROOM.length);
            return String.valueOf(randomFloor) + String.valueOf(randomRoom);
        }
    }

    private static class randomNumberComparator implements Comparator<ResidentRoom> {
        @Override
        public int compare(ResidentRoom o1, ResidentRoom o2) {
            return o1.randomNumber.compareTo(o2.randomNumber);
        }
    }
}
