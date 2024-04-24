package com.example.ecommerce.dtos.order;

import com.example.ecommerce.dtos.OrderItem.OrderItemRequest;

import java.util.List;

public record OrderRequest(
        Long userId,
        List<OrderItemRequest> orderItems
) {
}
