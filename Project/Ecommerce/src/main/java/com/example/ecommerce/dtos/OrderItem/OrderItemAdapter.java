package com.example.ecommerce.dtos.OrderItem;

import com.example.ecommerce.models.OrderItem;

import java.util.List;

public class OrderItemAdapter {

    public static OrderItemResponse getOrderItemResponseFromOder(OrderItem item) {
        OrderItemResponse orderItemResponse = new OrderItemResponse(
                item.getOrder().getId(),
                item.getProduct().getId(),
                item.getQuantity(),
                item.getPrice()
        );
        return orderItemResponse;
    }

    public static List<OrderItemResponse> getOrderItemResponseFromOder(List<OrderItem> items) {
        return items.stream().map(item -> getOrderItemResponseFromOder(item)).toList();
    }
}
