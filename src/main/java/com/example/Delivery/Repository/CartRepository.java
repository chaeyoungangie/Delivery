package com.example.Delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserid(int userid);
    
}