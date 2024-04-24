package com.example.ecommerce.dtos.cart.cartItem;

public record CartItemResponse(
        Long id,
        Long productId,
        Long cartId,
        Long quantity,
        Double price
) {
}
