package com.example.delivery.dto;


import lombok.Getter;

@Getter
public class CartRequest {
    private int count;
    private int productid;
    private String token;
  
}