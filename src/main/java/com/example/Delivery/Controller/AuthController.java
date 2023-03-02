package com.example.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dto.AuthenticationResponse;
import com.example.delivery.dto.ChangeAccountRequest;
import com.example.delivery.dto.LoginRequest;
import com.example.delivery.dto.RegisterRequest;
import com.example.delivery.service.AuthService;

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
