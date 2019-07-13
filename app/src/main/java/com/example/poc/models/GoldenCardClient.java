package com.example.poc.models;

import lombok.Data;

@Data
public class GoldenCardClient extends Client {
    public GoldenCardClient(int id, String fullName) {
        super(id, fullName, 30);
    }

    public GoldenCardClient(String fullName) {
        super(fullName, 30);
    }
}
