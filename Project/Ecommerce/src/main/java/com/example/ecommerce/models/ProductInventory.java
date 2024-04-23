package com.example.ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventory {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Product product;
    private Long amountLeft;

    public ProductInventory(Long amountLeft) {
        this.amountLeft = amountLeft;
    }

    public ProductInventory(Product product, Long amountLeft) {
        this.product = product;
        this.amountLeft = amountLeft;
    }
}
