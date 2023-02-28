package com.example.Delivery.service;

import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.dto.UserResponse;

public interface UsersService {
    
    public UserResponse getAccount(AuthenticationRequest request);
    
}
