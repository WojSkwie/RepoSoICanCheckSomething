package com.example.poc.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reservation {
    private int id;
    private Room room;
    private boolean wasPaid;
    private Date startDate;
    private Date endDate;



}
