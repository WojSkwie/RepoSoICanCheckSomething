package com.example.poc.models;

import lombok.Data;

@Data
public class RegularClient extends Client {

    public RegularClient(int id, String fullName) {
        super(id, fullName, 10);
    }

    public RegularClient(String fullName) {
        super(fullName, 10);
    }
}
