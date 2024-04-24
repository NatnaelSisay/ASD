package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse save(OrderRequest orderRequest) throws Exception;

    List<OrderResponse> findAllByUserId(Long userId);

    List<OrderResponse> findAll();
}
