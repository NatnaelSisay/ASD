package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.servicies.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<ResponseDataList> findAll() {
        List<OrderResponse> orderResponses = this.orderService.findAll();
        return ResponseEntity.ok(new ResponseDataList(orderResponses));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDataList> findAllByUserId(@PathVariable Long userId) {
        List<OrderResponse> orderResponses = this.orderService.findAllByUserId(userId);
        return ResponseEntity.ok(new ResponseDataList(orderResponses));
    }

    @PostMapping
    public ResponseEntity<ResponseData> save(@RequestBody OrderRequest orderRequest) throws Exception {
        OrderResponse orderResponse = this.orderService.save(orderRequest);
        return ResponseEntity.ok(new ResponseData(orderResponse));
    }

}
