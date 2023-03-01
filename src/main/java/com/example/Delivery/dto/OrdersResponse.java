package com.example.Delivery.dto;

import java.util.List;

import com.example.Delivery.model.OrderEach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OrdersResponse {
    private int orderid;
    private List<OrderEach> orders_list;
}
