package com.example.Delivery.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeAccountRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String token;
}
