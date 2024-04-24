package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.product.ProductAdapter;
import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.dtos.product.ProductRequest;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.servicies.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(ProductRequest productRequest) {
        Product p = ProductAdapter.getProductFromRequest(productRequest);
        p = this.productRepository.save(p);
        ProductDTO response = ProductAdapter.getProductDTOFromProduct(p);
        return response;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = this.productRepository.findAll();
        return ProductAdapter.getProductDTOFromProduct(products);
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = this.productRepository.findById(id).orElse(null);
        return ProductAdapter.getProductDTOFromProduct(product);
    }

    @Override
    public void deleteById(Long productId) {
        this.productRepository.deleteById(productId);
    }

    @Override
    public ProductDTO update(Product productRequest) {
        Product p = this.productRepository.findById(productRequest.getId()).orElse(null);
        if (p == null) return null;

        p.setName(productRequest.getName());
        p.setTitle(productRequest.getTitle());
        p.setDescription(productRequest.getDescription());
        p.setUnitPrice(productRequest.getUnitPrice());

        p = this.productRepository.save(p);
        return ProductAdapter.getProductDTOFromProduct(p);
    }
}
