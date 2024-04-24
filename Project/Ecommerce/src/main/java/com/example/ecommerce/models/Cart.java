package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<CartItem> items = new ArrayList<>();

    public Cart(User user, List<CartItem> items) {
        this.user = user;
        this.items = items;
    }
}
