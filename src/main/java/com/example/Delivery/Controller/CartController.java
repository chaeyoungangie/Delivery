package com.example.Delivery.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.Cart;
import com.example.Delivery.Model.CartOrderRequest;
import com.example.Delivery.Model.CartRequest;
import com.example.Delivery.Model.CartResponse;
import com.example.Delivery.Service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartservice;

    @PostMapping("/add")
    public ResponseEntity<String> addCart(@RequestBody CartRequest request) {
        return ResponseEntity.ok(cartservice.addCart(request));
    }

    @PostMapping("/mycart")
    public ResponseEntity<List<CartResponse>> mycart(@RequestBody AuthenticationResponse request) {
        return ResponseEntity.ok(cartservice.getmycart(request));
    }

    @PostMapping("/placeorder")
    public ResponseEntity<String> placeorder(@RequestBody List<CartOrderRequest> request) {
        System.out.println("placeorder in");
        System.out.println(request);
        return ResponseEntity.ok(cartservice.placeorder(request));
    }
}
