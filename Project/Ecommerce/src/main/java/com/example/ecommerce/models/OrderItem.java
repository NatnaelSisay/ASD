package com.example.ecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private UserOrder order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Long quantity;
    private Double price;

    public OrderItem(UserOrder order, Product product, Long quantity, Double price) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
