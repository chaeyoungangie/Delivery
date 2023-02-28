package com.example.Delivery.dto;

import java.util.List;

import com.example.Delivery.model.OrderEach;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponse {
    private int orderid;
    private List<OrderEach> orders_list;
}
