package com.example.Delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
}
