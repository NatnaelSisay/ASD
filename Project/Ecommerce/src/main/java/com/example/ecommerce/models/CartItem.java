package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    private Long quantity;
    private Double price;

    public CartItem(Product product, Cart cart, Long quantity, Double price) {
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.price = price;
    }
}
