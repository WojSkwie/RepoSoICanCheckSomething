package com.example.poc.models;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Hotel {
    private int id;
    private String address;
    private int stars;
    private ArrayList<Room> rooms;
}
