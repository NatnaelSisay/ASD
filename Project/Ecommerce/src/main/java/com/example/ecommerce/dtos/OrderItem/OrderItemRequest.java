package com.example.ecommerce.dtos.OrderItem;

public record OrderItemRequest(
        Long productId,
        Long quantity
) {
}
