package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.dtos.product.ProductRequest;
import com.example.ecommerce.servicies.ProductService;
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

    @GetMapping
    public ResponseEntity<ResponseDataList> findAll() {
        List<ProductDTO> result = this.productService.findAll();
        return ResponseEntity.ok(new ResponseDataList(result));
    }

    @PostMapping
    public ResponseEntity<ResponseData<ProductDTO>> save(
            @RequestBody ProductRequest productRequest
    ) {
        ProductDTO result = this.productService.save(productRequest);
        return ResponseEntity.ok(new ResponseData(result));
    }
}
