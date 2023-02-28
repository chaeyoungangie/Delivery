package com.example.Delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.dto.AuthenticationResponse;
import com.example.Delivery.dto.ChangeAccountRequest;
import com.example.Delivery.dto.LoginRequest;
import com.example.Delivery.dto.RegisterRequest;
import com.example.Delivery.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authservice;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authservice.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authservice.login(request));
    }

    @PostMapping("/change")
    public ResponseEntity<AuthenticationResponse> change(@RequestBody ChangeAccountRequest request) {
        return ResponseEntity.ok(authservice.change(request));
    }
}
