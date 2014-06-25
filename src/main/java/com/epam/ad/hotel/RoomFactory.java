package com.epam.ad.hotel;

import java.math.BigDecimal;
import java.util.Random;

public class RoomFactory {
    public static Room createRandomRoom() {
        Room room = null;
        int x = new Random().nextInt(5);
        switch (x) {
            case 0:
                return new ResidentRoom.Builder()

                        .breakfast(false)
                        .roomType(ResidentRoom.Type.SINGLEROOM)
                        .wiFi(false)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.SINGLEROOM_PRICE))
                        .build();

            case 1:
                return new ResidentRoom.Builder()
                        .roomType(ResidentRoom.Type.TRIPLEROOM)
                        .breakfast(true)
                        .wiFi(true)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.TRIPLEROOM_PRICE))
                        .build();

            case 2:
                return new ResidentRoom.Builder()
                        .breakfast(true).wiFi(false)
                        .roomType(ResidentRoom.Type.DOOBLEROOM)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.DOUBLEROOM_PRICE))
                        .build();

            case 3:
                return new ConferenceRoom.Builder()
                        .size(50)
                        .numberOfSeats(15)
                        .initialCost(BigDecimal.valueOf(2500))
                        .build();

            case 4:
                return new ConferenceRoom.Builder()
                        .size(100)
                        .numberOfSeats(30)
                        .initialCost(BigDecimal.valueOf(5000))
                        .build();


        }
        return room;


    }

    public static ResidentRoom createRandomResidentRoom() {
        ResidentRoom room = null;
        int x = new Random().nextInt(3);
        switch (x) {
            case 0:
                return new ResidentRoom.Builder()

                        .breakfast(false)
                        .roomType(ResidentRoom.Type.SINGLEROOM)
                        .wiFi(false)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.SINGLEROOM_PRICE))
                        .build();

            case 1:
                return new ResidentRoom.Builder()
                        .roomType(ResidentRoom.Type.TRIPLEROOM)
                        .breakfast(true)
                        .wiFi(true)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.TRIPLEROOM_PRICE))
                        .build();

            case 2:
                return new ResidentRoom.Builder()
                        .breakfast(true).wiFi(false)
                        .roomType(ResidentRoom.Type.DOOBLEROOM)
                        .initialCost(BigDecimal.valueOf(ResidentRoom.DOUBLEROOM_PRICE))
                        .build();


        }
        return room;


    }

}
