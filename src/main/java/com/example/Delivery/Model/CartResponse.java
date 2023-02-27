package com.example.Delivery.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {
    private int count;
    private int productid;
    private int price;
    private String name;
    private String img_path;
}
