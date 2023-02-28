package com.example.Delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(int categoryId);
    Product findById(int id);

}
