package com.example.ecommerce.dtos.product;

import com.example.ecommerce.dtos.category.CategoryResponse;
import com.example.ecommerce.dtos.productInventory.ProductInventoryResponseShort;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDTO {
    Long id;
    String name;
    String title;
    String description;
    Double unitPrice;
    ProductInventoryResponseShort inventory;
    List<CategoryResponse> categories;

    public ProductDTO(
            Long id,
            String name,
            String title,
            String description,
            Double unitPrice,
            ProductInventoryResponseShort inventory,
            List<CategoryResponse> categories
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
        this.categories = categories;
    }
}
