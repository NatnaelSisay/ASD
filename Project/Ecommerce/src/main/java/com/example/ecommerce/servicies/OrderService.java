package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;

public interface OrderService {
    OrderResponse save(OrderRequest orderRequest) throws Exception;
}
