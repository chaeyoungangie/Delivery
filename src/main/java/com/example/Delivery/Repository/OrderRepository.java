package com.example.Delivery.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Delivery.Model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{
    List<Orders> findByUserid(int userid);
}
