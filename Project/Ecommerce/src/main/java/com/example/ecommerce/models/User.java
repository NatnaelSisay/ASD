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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    private List<Role> roles = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<UserOrder> order;
    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;

    public User(String firstName, String lastName, String email, String password, List<Role> role, Address address) {
        this(firstName, lastName, email, password, role);
        this.address = address;
    }

    public User(String firstName, String lastName, String email, String password, List<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        if (role != null) {
            this.roles = role;
        }
    }
}
