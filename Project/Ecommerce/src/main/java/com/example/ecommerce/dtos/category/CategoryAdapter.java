package com.example.ecommerce.dtos.category;

import com.example.ecommerce.models.Category;

import java.util.List;

public class CategoryAdapter {
    public static Category getCategoryFromRequest(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        return category;
    }

    public static List<Category> getCategoryListFromRequest(List<CategoryRequest> categories) {
        return categories.stream().map(
                category -> getCategoryFromRequest(category)
        ).toList();
    }

    public static CategoryResponse getCategoryResponse(Category category) {
        CategoryResponse cr = new CategoryResponse(
                category.getId(),
                category.getName()
        );
        return cr;
    }

    public static List<CategoryResponse> getCategoryListResponse(List<Category> categories) {
        return categories.stream().map(
                category -> getCategoryResponse(category)
        ).toList();
    }
}
