package com.example.Delivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.Model.OrderEach;

public interface OrderEachRepository extends JpaRepository<OrderEach, Integer> {
    
}
