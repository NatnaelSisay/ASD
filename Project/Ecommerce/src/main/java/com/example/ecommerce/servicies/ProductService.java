package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.dtos.product.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public ProductDTO save(ProductRequest product);

    public List<ProductDTO> findAll();

    public ProductDTO findById(Long id);
}