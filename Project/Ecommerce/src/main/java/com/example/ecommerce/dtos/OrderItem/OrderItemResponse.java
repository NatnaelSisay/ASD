package com.example.ecommerce.dtos.OrderItem;

public record OrderItemResponse(
        Long orderId,
        Long productId,
        Long quantity,
        Double price
) {
}
