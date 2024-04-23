package com.example.ecommerce.dtos.product;

import com.example.ecommerce.dtos.category.CategoryResponse;
import com.example.ecommerce.dtos.productInventory.ProductInventoryResponseShort;

import java.util.List;

public record ProductDTO(
        Long id,
        String name,
        String title,
        String description,
        Double unitPrice,
        ProductInventoryResponseShort inventory,
        List<CategoryResponse> categories
) {
}
