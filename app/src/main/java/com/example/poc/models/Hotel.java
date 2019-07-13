package com.example.poc.models;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Hotel implements Serializable {
    private int id;
    private String address;
    private int stars;
    private ArrayList<Room> rooms;
    private String name;
}
