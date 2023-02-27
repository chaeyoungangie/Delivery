package com.example.Delivery.Service;

import java.util.List;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.OrdersResponse;

public interface OrderService {

    public List<OrdersResponse> getorder(AuthenticationResponse request);

}
