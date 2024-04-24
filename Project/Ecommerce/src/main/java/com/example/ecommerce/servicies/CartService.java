package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.cart.CartRequest;
import com.example.ecommerce.dtos.cart.CartResponse;

public interface CartService {
    CartResponse save(CartRequest cartRequest) throws Exception;

    CartResponse findAByUserId(Long userId);
}
