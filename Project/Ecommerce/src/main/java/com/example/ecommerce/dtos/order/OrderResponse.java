package com.example.ecommerce.dtos.order;

import com.example.ecommerce.dtos.OrderItem.OrderItemResponse;

import java.util.List;

public record OrderResponse(
        Long id,
        Long userId,
        Double totalAmount,
        List<OrderItemResponse> items
) {
}
