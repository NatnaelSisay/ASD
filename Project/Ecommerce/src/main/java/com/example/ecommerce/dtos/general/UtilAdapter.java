package com.example.ecommerce.dtos.general;

import com.example.ecommerce.dtos.OrderItem.OrderItemRequest;
import com.example.ecommerce.dtos.cart.cartItem.CartItemResponse;

import java.util.List;

public class UtilAdapter {

    public static OrderItemRequest getOrderItemFromCartItem(CartItemResponse cartResponse) {
        OrderItemRequest orderItemRequest = new OrderItemRequest(
                cartResponse.productId(),
                cartResponse.quantity()
        );

        return orderItemRequest;
    }

    public static List<OrderItemRequest> getOrderItemFromCartItem(List<CartItemResponse> cartResponse) {
        return cartResponse.stream().map(
                cartItemResponse -> getOrderItemFromCartItem(cartItemResponse)
        ).toList();
    }
}
