package com.example.Delivery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.Model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserid(int userid);
    
}