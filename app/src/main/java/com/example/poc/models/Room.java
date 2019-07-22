package com.example.poc.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room implements Serializable {

    private int id;
    private double price;
    private int roomNumber;
    private int beds;
    private boolean hasSeparateBathroom;
    private boolean isNoSmokingRoom;
    private Hotel hotel;

    public Room(double price, int roomNumber, int beds, boolean hasSeparateBathroom, boolean isNoSmokingRoom, Hotel hotel) {
        this.price = price;
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.hasSeparateBathroom = hasSeparateBathroom;
        this.isNoSmokingRoom = isNoSmokingRoom;
        this.hotel = hotel;
    }
}


