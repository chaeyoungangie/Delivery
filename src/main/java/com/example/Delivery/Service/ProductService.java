package com.example.Delivery.service;

import java.util.List;

import com.example.Delivery.dto.ProductResponse;

public interface ProductService {

    public List<ProductResponse> getAllproducts();
    public List<ProductResponse> findByCategoryId(int categoryid);
    
}
