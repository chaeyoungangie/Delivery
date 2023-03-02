package com.example.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CartResponse {
    private int count;
    private int productid;
    private int price;
    private String name;
    private String img_path;
}
