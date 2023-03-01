package com.example.Delivery.dto;


import lombok.Getter;

@Getter
public class CartRequest {
    private int count;
    private int productid;
    private String token;
  
}