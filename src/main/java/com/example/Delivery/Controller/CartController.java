package com.example.delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dto.AuthenticationRequest;
import com.example.delivery.dto.CartOrderRequestWrapper;
import com.example.delivery.dto.CartRequest;
import com.example.delivery.dto.CartResponse;
import com.example.delivery.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartservice;

    @PostMapping("/add")
    public String addCart(@RequestBody CartRequest request) {
        return cartservice.addCart(request);
    }

    @PostMapping("/mycart")
    public List<CartResponse> myCart(@RequestBody AuthenticationRequest request) {
        return cartservice.myCart(request);
    }

    @PostMapping("/placeorder")
    public String placeOrder(@RequestBody CartOrderRequestWrapper request) {
        return cartservice.placeOrder(request);
    }
}
