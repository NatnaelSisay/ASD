package com.example.ecommerce.controllers;


import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.product.ProductDTO;
import com.example.ecommerce.servicies.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestProductController {
    @Mock
    ProductService productService;
    @InjectMocks
    ProductController productController;

    @Test
    public void testGetAllProducts() {
        List<ProductDTO> productDTOS = List.of(new ProductDTO(), new ProductDTO());
        when(productService.findAll()).thenReturn(productDTOS);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<ResponseDataList> response = productController.findAll();

        assertEquals(response.getBody().getData().size(), 2);
        verify(productService, atMostOnce()).findAll();
    }
}
