package com.example.poc.models;

import lombok.Data;

@Data
public class NormalClient extends Client {

    public NormalClient(int id, String fullName) {
        super(id, fullName, 0);
    }

    public NormalClient(String fullName) {
        super(fullName, 0);
    }
}
