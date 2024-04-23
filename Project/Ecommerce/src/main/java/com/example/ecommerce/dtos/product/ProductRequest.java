package com.example.ecommerce.dtos.product;

import com.example.ecommerce.dtos.category.CategoryRequest;
import com.example.ecommerce.dtos.productInventory.ProductInventoryRequest;

import java.util.List;

public record ProductRequest(
        String name,
        String title,
        String description,
        Double unitPrice,
        ProductInventoryRequest inventory,
        List<CategoryRequest> categories
) {
}
