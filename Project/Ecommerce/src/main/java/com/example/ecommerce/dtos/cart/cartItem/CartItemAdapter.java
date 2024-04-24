package com.example.ecommerce.dtos.cart.cartItem;

import com.example.ecommerce.models.CartItem;

import java.util.List;

public class CartItemAdapter {
    public static CartItemResponse getCartItemResponseFromCart(CartItem item) {
        CartItemResponse response = new CartItemResponse(
                item.getId(),
                item.getProduct().getId(),
                item.getCart().getId(),
                item.getQuantity(),
                item.getPrice()
        );
        return response;
    }

    public static List<CartItemResponse> getCartItemResponseFromCart(List<CartItem> items) {
        return items.stream().map(
                item -> getCartItemResponseFromCart(item)
        ).toList();
    }
}
