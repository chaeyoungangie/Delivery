package com.example.Delivery.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.OrdersResponse;
import com.example.Delivery.Service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderservice;
    
    @PostMapping("/myorder")
    public ResponseEntity<List<OrdersResponse>> getorder(@RequestBody AuthenticationResponse request) {
            return ResponseEntity.ok(orderservice.getorder(request));
    }
}
