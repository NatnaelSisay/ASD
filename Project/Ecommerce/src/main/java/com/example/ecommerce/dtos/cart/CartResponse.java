package com.example.ecommerce.dtos.cart;

import com.example.ecommerce.dtos.cart.cartItem.CartItemResponse;

import java.util.List;

public record CartResponse(
        Long id,
        Long userId,
        List<CartItemResponse> items
) {
}
