package com.example.delivery.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class CartOrderRequestWrapper {
    private List<CartOrderRequest> cartorder;
    private String token;
}
