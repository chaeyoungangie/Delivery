package com.example.Delivery.Service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.Delivery.Auth.JwtService;
import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.UserResponse;
import com.example.Delivery.Repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final JwtService jwtservice;
    private final UsersRepository userrepository;

    /*
     * parameter(in): AuthenticationResponse
     * return(out): UserResponse
     * purpose: show user's account info 
     */
    public UserResponse getAccount(AuthenticationResponse request) {
        var token_ = request.getToken();
        var username = jwtservice.extractUsername(token_);
        var user = userrepository.findByUsername(username).orElseThrow();

        return UserResponse.builder()
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .email(user.getEmail())
                    .username(user.getUsername())
                    .build();
    }
}
