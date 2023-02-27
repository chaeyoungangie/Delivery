package com.example.Delivery.Service;

import java.util.List;

import com.example.Delivery.Model.ProductResponse;

public interface ProductService {

    public List<ProductResponse> getAllproducts();
    public List<ProductResponse> findByCategoryId(int categoryid);
    
}
