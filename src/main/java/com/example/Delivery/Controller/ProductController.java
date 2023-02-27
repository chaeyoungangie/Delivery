package com.example.Delivery.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Delivery.Model.ProductResponse;
import com.example.Delivery.Service.ProductService;

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
    public ResponseEntity<List<ProductResponse>> findByCategoryId(@RequestBody Map<String, Integer> category) {
        return ResponseEntity.ok(productService.findByCategoryId(category.get("categoryid")));
    } 
}
