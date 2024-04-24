package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.order.OrderAdapter;
import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.models.OrderItem;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.models.UserOrder;
import com.example.ecommerce.repositories.OrderItemRepository;
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
    OrderItemRepository orderItemRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            ProductRepository productRepository,
            OrderItemRepository orderItemRepository
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        System.out.println(orderRequest);

        User user = userRepository.findById(orderRequest.userId()).orElse(null);

        final UserOrder order = new UserOrder();
        order.setUser(user);

        List<OrderItem> orderItems = orderRequest.orderItems().stream().map(item -> {
            try {
                Product product = productRepository.findById(item.productId()).orElse(null);
                double itemPrice = item.quantity() * product.getUnitPrice();
                return orderItemRepository.save(new OrderItem(order, product, item.quantity(), itemPrice));
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

    @Override
    public List<OrderResponse> findAllByUserId(Long userId) {
        List<UserOrder> orders = this.orderRepository.findByUserId(userId);
        return OrderAdapter.getOrderResponseFromOrder(orders);
    }

    @Override
    public List<OrderResponse> findAll() {
        List<UserOrder> orders = this.orderRepository.findAll();
        return OrderAdapter.getOrderResponseFromOrder(orders);
    }
}
