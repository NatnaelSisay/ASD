package com.example.ecommerce.dtos.cart;

public record CartRequest(
        Long userId,
        Long productId,
        Long quantity
) {
}
