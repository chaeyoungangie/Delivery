package com.example.Delivery.dto;

import lombok.Data;

@Data
public class CartOrderRequest {
    private int productid;
    private int count;
}
