package com.example.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.delivery.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserid(int userid);
    @Transactional
    int deleteByUserid(int userid);
    
}