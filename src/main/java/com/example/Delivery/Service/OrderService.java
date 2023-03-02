package com.example.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.delivery.auth.JwtService;
import com.example.delivery.dto.AuthenticationRequest;
import com.example.delivery.dto.OrdersResponse;
import com.example.delivery.model.Orders;
import com.example.delivery.repository.OrderRepository;
import com.example.delivery.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService{
    private final JwtService jwtservice;
    private final UsersRepository userrepository;
    private final OrderRepository orderrepository;

    /*
     * parameter(in): AuthenticationResponse
     * return(out): List<OrdersResponse>
     * purpose: show all the products in the orders (for check)
     */
    public List<OrdersResponse> myOrder(AuthenticationRequest request) {
        var username = jwtservice.extractUsername(request.getToken());
        var user = userrepository.findByUsername(username).orElseThrow();  
        var userid = user.getId();
        List<Orders> getorders = orderrepository.findByUserid(userid);
        List<OrdersResponse> myorders = new ArrayList<>();
        for (Orders o: getorders) {
            var order = OrdersResponse.builder().orderid(o.getId()).orders_list(o.getOrders_list()).build();
            myorders.add(order);
        }

        return myorders;
    }
}
