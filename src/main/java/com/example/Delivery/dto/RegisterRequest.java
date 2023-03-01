package com.example.Delivery.dto;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}
