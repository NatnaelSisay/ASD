package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.servicies.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<ResponseData> save(@RequestBody OrderRequest orderRequest) throws Exception {
        OrderResponse orderResponse = this.orderService.save(orderRequest);
        return ResponseEntity.ok(new ResponseData(orderResponse));
    }
}
