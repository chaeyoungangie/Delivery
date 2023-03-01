package com.example.Delivery.dto;

import lombok.Getter;

@Getter
public class ChangeAccountRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String token;
}
