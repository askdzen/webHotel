package com.epam.ad.hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hotel implements Cloneable {
    public List<Room> mainBuildRooms = new ArrayList<Room>();
    public List<ResidentRoom> secondBuildingRooms = new ArrayList<ResidentRoom>();
    private String name;
    private String address;
    private int roomCount;

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;

    }

    public Hotel sortRooms() throws CloneNotSupportedException {
        Hotel clone = clone();
        //clone.add(RoomFactory.createRandomRoom());
        Collections.sort(clone.mainBuildRooms);
        //System.out.println(clone);
        return clone;
    }

    @Override
    protected Hotel clone() {
        try {
            Hotel clone = (Hotel) super.clone();
            List<Room> cloneRooms = new ArrayList<Room>();
            for (Room room : this.mainBuildRooms) {
                cloneRooms.add(room);
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            new AssertionError();
        }
        return null;
    }

    public Hotel sortSecondBuilding(Comparator<ResidentRoom> comparator) {
        Hotel clone = clone();
        Collections.sort(clone.secondBuildingRooms, comparator);
        return clone;
    }

    public void add(ResidentRoom room) {
        secondBuildingRooms.add(room);
        roomCount++;
    }

    public void add(Room room) {
        mainBuildRooms.add(room);
        roomCount++;

    }

    public BigDecimal getTotalRoomsCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Room room : mainBuildRooms) {
            totalCost = totalCost.add(room.getCurrentCost());
        }
        return totalCost;
    }

    @Override
    public String toString() {

        return "Hotel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", roomCount=" + roomCount +
                ", Total Cost=" + getTotalRoomsCost() +
                ", mainBuildRooms:" + "\n" + mainBuildRooms.subList(0, 50) +
                ", secondBuildingRooms:" + "\n" + secondBuildingRooms.subList(0, 50) +
                '}';


    }

    public List<ResidentRoom> findResidentRoomsByPriceLimit(BigDecimal upLimit, BigDecimal downLimit) {
        List<ResidentRoom> result = new ArrayList<ResidentRoom>();

        for (ResidentRoom room : secondBuildingRooms) {

            if ((room.getCurrentCost().compareTo(upLimit) < 0) && (room.getCurrentCost().compareTo(downLimit) > 0)) {
                result.add(room);
            }
        }
        return result;
    }
/*
    public List<ResidentRoom> findResidentRoomsByPriceDownLimit(BigDecimal downLimit) {
        List<ResidentRoom> result = new ArrayList<ResidentRoom>();

        for (ResidentRoom room : secondBuildingRooms) {

            if (room.getCurrentCost().compareTo(downLimit) > 0) {
                result.add(room);
            }
        }
        return result;
    }
*/

}
