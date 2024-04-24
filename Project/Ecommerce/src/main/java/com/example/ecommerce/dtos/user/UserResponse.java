package com.example.ecommerce.dtos.user;

import com.example.ecommerce.dtos.cart.CartResponse;
import com.example.ecommerce.dtos.order.OrderResponse;

import java.util.List;

public record UserResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        String roles,
        CartResponse cart,
        List<OrderResponse> orders
) {
}
