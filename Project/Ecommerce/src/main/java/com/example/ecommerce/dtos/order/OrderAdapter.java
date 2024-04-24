package com.example.ecommerce.dtos.order;

import com.example.ecommerce.dtos.OrderItem.OrderItemAdapter;
import com.example.ecommerce.models.UserOrder;

import java.util.List;

public class OrderAdapter {

    public static OrderResponse getOrderResponseFromOrder(UserOrder order) {
        if (order == null) return null;


        OrderResponse orderResponse = new OrderResponse(
                order.getId(),
                order.getUser().getId(),
                order.getTotalAmount(),
                OrderItemAdapter.getOrderItemResponseFromOder(order.getItems())
        );

        return orderResponse;
    }

    public static List<OrderResponse> getOrderResponseFromOrder(List<UserOrder> orders) {
        return orders.stream().map(
                order -> getOrderResponseFromOrder(order)
        ).toList();
    }
}
