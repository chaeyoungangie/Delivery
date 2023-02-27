package com.example.Delivery.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String imgPath;
    private String name;
    private int price;
    private int categoryId;
}