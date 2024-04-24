package com.example.ecommerce.repositories;

import com.example.ecommerce.models.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(Long userId);
}
