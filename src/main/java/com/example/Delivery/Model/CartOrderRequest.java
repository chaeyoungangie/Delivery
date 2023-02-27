package com.example.Delivery.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartOrderRequest {
    private int productid;
    private int count;
    private String token;
}
