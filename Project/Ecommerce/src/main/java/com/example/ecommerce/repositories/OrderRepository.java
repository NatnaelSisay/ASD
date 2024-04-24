package com.example.ecommerce.repositories;

import com.example.ecommerce.models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
}
