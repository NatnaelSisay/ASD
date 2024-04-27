package com.example.ecommerce.services;

import com.example.ecommerce.dtos.product.ProductAdapter;
import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.servicies.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestProductService {
//    make sure to configure database before running test

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    Product product = new Product(
            "MacBook Pro",
            "MacBook Pro with M3 chip",
            "MacBook Pro with M3 chip 18GB RAM, 1TB storage",
            1666.99
    );

    @BeforeEach
    public void beforeEach() {
        product = productRepository.save(product);
    }

    @AfterEach
    public void afterEach() {
        productRepository.deleteById(product.getId());
    }

    @Test
    public void testFindProductById() {
        ProductDTO dto = ProductAdapter.getProductDTOFromProduct(product);
        ProductDTO productDTO = productService.findById(product.getId());
        assertEquals(dto, productDTO);
    }
}
