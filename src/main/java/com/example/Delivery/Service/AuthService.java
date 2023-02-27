package com.example.Delivery.Service;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.ChangeAccountRequest;
import com.example.Delivery.Model.LoginRequest;
import com.example.Delivery.Model.RegisterRequest;


public interface AuthService {

    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse login(LoginRequest request);
    public AuthenticationResponse change(ChangeAccountRequest request);

}
