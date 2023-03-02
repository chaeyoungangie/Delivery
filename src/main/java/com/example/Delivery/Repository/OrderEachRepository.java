package com.example.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.delivery.model.OrderEach;

public interface OrderEachRepository extends JpaRepository<OrderEach, Integer> {
    
}
