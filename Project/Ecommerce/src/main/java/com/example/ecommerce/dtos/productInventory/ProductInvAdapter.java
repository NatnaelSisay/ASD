package com.example.ecommerce.dtos.productInventory;

import com.example.ecommerce.models.ProductInventory;

public class ProductInvAdapter {

    public static ProductInventoryResponseShort getResponseShort(ProductInventory inventory) {
        if (inventory == null) return null;
        return new ProductInventoryResponseShort(
                inventory.getId(),
                inventory.getAmountLeft()
        );
    }
}
