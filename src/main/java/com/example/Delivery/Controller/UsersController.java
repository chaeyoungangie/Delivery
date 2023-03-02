package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dto.AuthenticationRequest;
import com.example.delivery.dto.UserResponse;
import com.example.delivery.service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService userservice;

    @PostMapping("/getAccount")
    public UserResponse getAccount(@RequestBody AuthenticationRequest request) {
        return userservice.getAccount(request);
    }
}
