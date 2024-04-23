package com.example.ecommerce.dtos.product;

public record ProductResponseLight(
        Long id,
        String name,
        String title,
        String description,
        Double unitPrice
) {
}
