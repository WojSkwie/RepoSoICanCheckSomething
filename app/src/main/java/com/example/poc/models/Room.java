package com.example.poc.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {

    private int id;
    private double price;
    private int roomNumber;
    private int beds;
    private boolean hasSeparateBathroom;
    private boolean isNoSmokingRoom;
}
