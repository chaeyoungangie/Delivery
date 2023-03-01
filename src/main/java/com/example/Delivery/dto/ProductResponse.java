package com.example.Delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponse {
    private int id;
    private String imgPath;
    private String name;
    private int price;
    private int categoryId;
}