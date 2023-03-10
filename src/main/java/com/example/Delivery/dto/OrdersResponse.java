package com.example.delivery.dto;

import java.util.List;

import com.example.delivery.model.OrderEach;

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
