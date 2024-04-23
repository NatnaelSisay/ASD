package com.example.ecommerce.dtos.productInventory;

import com.example.ecommerce.models.ProductInventory;

public class ProductInvAdapter {

    public static ProductInventoryResponseShort getResponseShort(ProductInventory inventory) {
        return new ProductInventoryResponseShort(
                inventory.getId(),
                inventory.getAmountLeft()
        );
    }
}
