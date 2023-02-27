package com.example.Delivery.Service;

import java.util.List;

import com.example.Delivery.Model.AuthenticationResponse;
import com.example.Delivery.Model.CartOrderRequest;
import com.example.Delivery.Model.CartRequest;
import com.example.Delivery.Model.CartResponse;


public interface CartService {

    public String addCart(CartRequest request);
    public List<CartResponse> getmycart(AuthenticationResponse request);
    public String placeorder(List<CartOrderRequest> request);

}
