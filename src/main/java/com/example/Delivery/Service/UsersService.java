package com.example.Delivery.Service;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.UserResponse;

public interface UsersService {
    
    public UserResponse getAccount(AuthenticationResponse request);
    
}
