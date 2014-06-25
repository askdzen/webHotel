package com.epam.ad.hotel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

/**
 * Created by Askar on 25.06.2014.
 */
public class HotelRoomsOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hotel hotel = HotelFactory.createRandomHotel();
        try {
            hotel.sortRooms();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        hotel.sortSecondBuilding(ResidentRoom.RESIDENT_ROOM_COMPARATOR);
        PrintWriter writer=response.getWriter();
        writer.println("Conclusion rooms of the main building, sorted by price and second building sorted by number:");
        writer.println(hotel);
        writer.println("Conclusion rooms on the second building at a price not higher than 1000 and not lower than 500");
        writer.println(hotel.findResidentRoomsByPriceLimit(BigDecimal.valueOf(1000), BigDecimal.valueOf(500)));

    }
}
