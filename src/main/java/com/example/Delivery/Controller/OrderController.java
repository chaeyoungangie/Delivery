package com.example.Delivery.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.dto.OrdersResponse;
import com.example.Delivery.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderservice;
    
    @PostMapping("/myorder")
    public List<OrdersResponse> myOrder(@RequestBody AuthenticationRequest request) {
            return orderservice.myOrder(request);
    }
}
