package com.example.ecommerce.dtos.category;

import com.example.ecommerce.models.Category;

import java.util.List;

public class CategoryAdapter {
    public static Category getCategoryFromRequest(CategoryRequest categoryRequest) {
        if (categoryRequest == null) return null;
        Category category = new Category();
        category.setName(categoryRequest.name());
        return category;
    }

    public static List<Category> getCategoryListFromRequest(List<CategoryRequest> categories) {
        if (categories == null) return null;
        return categories.stream().map(
                category -> getCategoryFromRequest(category)
        ).toList();
    }

    public static CategoryResponse getCategoryResponse(Category category) {
        if (category == null) return null;
        CategoryResponse cr = new CategoryResponse(
                category.getId(),
                category.getName()
        );
        return cr;
    }

    public static List<CategoryResponse> getCategoryListResponse(List<Category> categories) {
        if (categories == null || categories.isEmpty()) return null;
        return categories.stream().map(
                category -> getCategoryResponse(category)
        ).toList();
    }
}
