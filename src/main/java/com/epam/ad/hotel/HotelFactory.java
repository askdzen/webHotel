package com.epam.ad.hotel;

public class HotelFactory {
    public static Hotel createRandomHotel() {
        Hotel hotel = new Hotel("California", "USA");

        for (int i = 0; i < 50; i++) {
            Room room = RoomFactory.createRandomRoom();
            hotel.add(room);
            ResidentRoom room1 = RoomFactory.createRandomResidentRoom();
            hotel.add(room1);
        }
        return hotel;
    }


}
