package com.example.Delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Delivery.model.Product;
import com.example.Delivery.dto.ProductResponse;
import com.example.Delivery.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService{
    private final ProductRepository productrepository;

    /*
     * parameter(in):
     * return(out): List<ProductResponse>
     * purpose: show all the products (for browsing)
     */
    public List<ProductResponse> getAllproducts() {
        List<Product> products = productrepository.findAll();
        List<ProductResponse> response = new ArrayList<>();
        for (Product p: products) {
            var product = ProductResponse.builder()
                                        .id(p.getId())
                                        .categoryId(p.getCategoryId())
                                        .imgPath(p.getImgPath())
                                        .name(p.getName())
                                        .price(p.getPrice()).build();
            response.add(product);
        }
        return response;
    }

    /*
     * parameter(in): int
     * return(out): List<ProductResponse>
     * purpose: show all the products by categoryId(for browsing)
     */
    public List<ProductResponse> findByCategoryId(int categoryid) {
        List<Product> products_category = productrepository.findByCategoryId(categoryid);
        List<ProductResponse> response = new ArrayList<>();
        for (Product p: products_category) {
            var product = ProductResponse.builder()
                                        .id(p.getId())
                                        .categoryId(p.getCategoryId())
                                        .imgPath(p.getImgPath())
                                        .name(p.getName())
                                        .price(p.getPrice()).build();
            response.add(product);
        }
        return response;
    }
    
}
