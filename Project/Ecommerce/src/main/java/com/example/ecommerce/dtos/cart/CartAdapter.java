package com.example.ecommerce.dtos.cart;

import com.example.ecommerce.dtos.cart.cartItem.CartItemAdapter;
import com.example.ecommerce.models.Cart;

public class CartAdapter {

    public static CartResponse getCartResponseFromCart(Cart savedCart) {
        if (savedCart == null) return null;

        CartResponse response = new CartResponse(
                savedCart.getId(),
                savedCart.getUser().getId(),
                CartItemAdapter.getCartItemResponseFromCart(savedCart.getItems())
        );

        return response;
    }
}
