package com.example.palaceecommerceapp.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Sender {
    private String name;
    private String email;

    public Sender(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
