package com.example.poc.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
abstract class Client {
    protected int id;
    protected String fullName;

    protected final double discountPercent;

    protected Client(String fullName, double discountPercent) {
        this.fullName = fullName;
        this.discountPercent = discountPercent;
    }
}
