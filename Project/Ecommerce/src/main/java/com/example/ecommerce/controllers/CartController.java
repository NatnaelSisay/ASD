package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.cart.CartRequest;
import com.example.ecommerce.dtos.cart.CartResponse;
import com.example.ecommerce.servicies.CartService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    //    TODO: order from cart
//    TODO: edit cart item
    CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseData> getCart(@PathVariable Long userId) {
        CartResponse cartResponse = this.cartService.findAByUserId(userId);
        return ResponseEntity.ok(new ResponseData(cartResponse));
    }

    @PostMapping
    public ResponseEntity<ResponseData> save(@RequestBody CartRequest cartRequest) throws Exception {
        CartResponse cartResponse = this.cartService.save(cartRequest);
        return ResponseEntity.ok(new ResponseData<>(cartResponse));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteCart(@PathVariable Long userId) {
        this.cartService.deleteByUserId(userId);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PostMapping("/{userId}/order")
    public ResponseEntity<ResponseData> orderCartItems(@PathVariable Long userId) {
        CartResponse cartResponse = this.cartService.orderCartItems(userId);
        return ResponseEntity.ok(new ResponseData(cartResponse));
    }
}
