package com.example.ecommerce.dtos.product;

import com.example.ecommerce.dtos.category.CategoryAdapter;
import com.example.ecommerce.dtos.category.CategoryResponse;
import com.example.ecommerce.dtos.productInventory.ProductInvAdapter;
import com.example.ecommerce.dtos.productInventory.ProductInventoryResponseShort;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.ProductInventory;

import java.util.List;

public class ProductAdapter {
    public static Product getProductFromRequest(ProductRequest productRequest) {
        if (productRequest == null) return null;

        Product product = new Product(
                productRequest.name(),
                productRequest.title(),
                productRequest.description(),
                productRequest.unitPrice()
        );

        ProductInventory inventory = new ProductInventory();
        inventory.setAmountLeft(productRequest.inventory().amountLeft());

        List<Category> categories = CategoryAdapter
                .getCategoryListFromRequest(productRequest.categories());

        product.setInventory(inventory);
        product.setCategories(categories);
        return product;
    }

    public static ProductDTO getProductDTOFromProduct(Product p) {
        if (p == null) return null;

        ProductInventoryResponseShort pi = ProductInvAdapter.getResponseShort(p.getInventory());
        List<CategoryResponse> cr = CategoryAdapter.getCategoryListResponse(p.getCategories());

        ProductDTO result = new ProductDTO(
                p.getId(),
                p.getName(),
                p.getTitle(),
                p.getDescription(),
                p.getUnitPrice(),
                pi,
                cr
        );

        return result;
    }

    public static List<ProductDTO> getProductDTOFromProduct(List<Product> products) {
        return products.stream().map(
                product -> getProductDTOFromProduct(product)
        ).toList();
    }
}
