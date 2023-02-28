package com.example.Delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.model.OrderEach;

public interface OrderEachRepository extends JpaRepository<OrderEach, Integer> {
    
}
