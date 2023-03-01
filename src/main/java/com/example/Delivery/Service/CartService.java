package com.example.Delivery.service;

import java.util.List;

import com.example.Delivery.dto.AuthenticationRequest;
import com.example.Delivery.dto.CartOrderRequestWrapper;
import com.example.Delivery.dto.CartRequest;
import com.example.Delivery.dto.CartResponse;


public interface CartService {

    public String addCart(CartRequest request);
    public List<CartResponse> myCart(AuthenticationRequest request);
    public String placeOrder(CartOrderRequestWrapper request);

}
