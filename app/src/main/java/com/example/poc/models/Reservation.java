package com.example.poc.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reservation {
    private int id;
    private int roomId;
    private boolean wasPaid;

    public Reservation(int roomId, boolean wasPaid) {
        this.roomId = roomId;
        this.wasPaid = wasPaid;
    }
}
