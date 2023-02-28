package com.example.Delivery.service;

import java.util.List;

import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.dto.CartOrderRequest;
import com.example.Delivery.dto.CartRequest;
import com.example.Delivery.dto.CartResponse;


public interface CartService {

    public String addCart(CartRequest request);
    public List<CartResponse> getmycart(AuthenticationRequest request);
    public String placeorder(List<CartOrderRequest> request);

}
