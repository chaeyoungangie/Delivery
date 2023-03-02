package com.example.delivery.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.delivery.dto.ProductResponse;
import com.example.delivery.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public List<ProductResponse> getAllproducts() {
        return productService.getAllproducts();
    } 

    @PostMapping("/findByCategoryId")
    public List<ProductResponse> findByCategoryId(@RequestBody Map<String, Integer> category) {
        return productService.findByCategoryId(category.get("categoryid"));
    } 
}
