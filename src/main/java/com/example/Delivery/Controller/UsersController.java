package com.example.Delivery.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.UserResponse;
import com.example.Delivery.Service.UsersService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService userservice;

    @PostMapping("/getAccount")
    public ResponseEntity<UserResponse> getAccount(@RequestBody AuthenticationResponse request) {
        return ResponseEntity.ok(userservice.getAccount(request));
    }
}
