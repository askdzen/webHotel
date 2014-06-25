package com.epam.ad.hotel;

import java.math.BigDecimal;

public abstract class Room implements Comparable<Room>,Cloneable { //арендуемое помещение
    public static final int[] FLOOR = new int[5];
    public static final int[] ROOM = new int[25];
    String randomNumber;
    BigDecimal price;

    public abstract BigDecimal getCurrentCost();

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNumber() {
        return randomNumber;
    }

    public void setNumber(String number) {
        this.randomNumber = number;
    }

    @Override
    public int compareTo(Room anotherRoom) {
        return this.price.compareTo(anotherRoom.price);
    }


}
