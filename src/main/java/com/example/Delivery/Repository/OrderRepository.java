package com.example.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.delivery.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
    List<Orders> findByUserid(int userid);
}
