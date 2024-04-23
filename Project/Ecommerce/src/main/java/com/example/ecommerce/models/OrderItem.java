package com.example.ecommerce.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate created_at;
}
