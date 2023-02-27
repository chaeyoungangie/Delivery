package com.example.Delivery.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Delivery.Auth.JwtService;
import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.Orders;
import com.example.Delivery.Model.OrdersResponse;
import com.example.Delivery.Repository.OrderRepository;
import com.example.Delivery.Repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final JwtService jwtservice;
    private final UsersRepository userrepository;
    private final OrderRepository orderrepository;

    /*
     * parameter(in): AuthenticationResponse
     * return(out): List<OrdersResponse>
     * purpose: show all the products in the orders (for check)
     */
    public List<OrdersResponse> getorder(AuthenticationResponse request) {
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
