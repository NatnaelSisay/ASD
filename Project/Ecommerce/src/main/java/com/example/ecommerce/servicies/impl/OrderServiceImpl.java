package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.order.OrderAdapter;
import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.models.OrderItem;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.models.UserOrder;
import com.example.ecommerce.repositories.OrderRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.servicies.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) throws Exception {
        System.out.println("---- Order Request --- ");
        System.out.println(orderRequest);

        User user = userRepository.findById(orderRequest.userId()).orElseThrow(() -> new Exception("user not found"));
        System.out.println("--- User ---");


        final UserOrder order = new UserOrder();
        order.setUser(user);

        List<OrderItem> orderItems = orderRequest.orderItems().stream().map(item -> {
            try {
                Product product = productRepository.findById(item.productId()).orElseThrow(() -> new Exception("Product not found"));
                double itemPrice = item.quantity() * product.getUnitPrice();

                return new OrderItem(order, product, item.quantity(), itemPrice);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList();

        Double totalPrice = orderItems.stream().mapToDouble(val -> val.getPrice()).reduce(0.0, (acc, val) -> acc + val);

        order.setTotalAmount(totalPrice);
        order.setItems(orderItems);

        UserOrder savedOrder = this.orderRepository.save(order);

        OrderResponse orderResponse = OrderAdapter.getOrderResponseFromOrder(savedOrder);
        return orderResponse;
    }
}
