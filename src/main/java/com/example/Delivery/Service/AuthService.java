package com.example.Delivery.service;

import com.example.Delivery.dto.AuthenticationResponse;
import com.example.Delivery.dto.ChangeAccountRequest;
import com.example.Delivery.dto.LoginRequest;
import com.example.Delivery.dto.RegisterRequest;


public interface AuthService {

    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse login(LoginRequest request);
    public AuthenticationResponse change(ChangeAccountRequest request);

}
