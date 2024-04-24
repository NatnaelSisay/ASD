package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Category> categories;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItems;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    List<CartItem> cartItems;
    //
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String title;
    private String description;
    private Double unitPrice;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "inventory_id")
    private ProductInventory inventory;
    private Boolean deleted = false;

    public Product(String name, String title, String description, Double unitPrice) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public void markAsDeleted() {
        this.deleted = true;
    }
}
