package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.dtos.product.ProductRequest;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.servicies.ProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ResponseData<ProductDTO>> findById(@PathVariable Long product_id) {
        ProductDTO productDTO = this.productService.findById(product_id);
        return ResponseEntity.ok(new ResponseData<>(productDTO));
    }

    @GetMapping
    public ResponseEntity<ResponseDataList> findAll() {
        List<ProductDTO> result = this.productService.findAll();
        return ResponseEntity.ok(new ResponseDataList(result));
    }

    @PostMapping
    public ResponseEntity<ResponseData<ProductDTO>> save(@RequestBody ProductRequest productRequest) {
        ProductDTO result = this.productService.save(productRequest);
        return ResponseEntity.ok(new ResponseData(result));
    }

    @PostMapping("/{product_id}/restore")
    public ResponseEntity<?> restoreProduct(
            @PathVariable Long product_id
    ) {
        this.productService.restoreProduct(product_id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PutMapping
    public ResponseEntity<ResponseData<ProductDTO>> update(@RequestBody Product productRequest) {
        ProductDTO result = this.productService.update(productRequest);
        return ResponseEntity.ok(new ResponseData(result));
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity deleteProduct(
            @PathVariable Long product_id
    ) {
        this.productService.deleteById(product_id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }


}
