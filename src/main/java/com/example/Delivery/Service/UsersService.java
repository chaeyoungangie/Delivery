package com.example.delivery.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.example.delivery.auth.JwtService;
import com.example.delivery.dto.AuthenticationRequest;
import com.example.delivery.dto.UserResponse;
import com.example.delivery.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final JwtService jwtservice;
    private final UsersRepository userrepository;

    /*
     * parameter(in): AuthenticationResponse
     * return(out): UserResponse
     * purpose: show user's account info 
     */
    public UserResponse getAccount(AuthenticationRequest request) {
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
