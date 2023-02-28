package com.example.Delivery.service;

import java.util.List;

import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.dto.OrdersResponse;

public interface OrderService {

    public List<OrdersResponse> getorder(AuthenticationRequest request);

}
