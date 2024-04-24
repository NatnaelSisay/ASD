package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.OrderItem.OrderItemRequest;
import com.example.ecommerce.dtos.cart.CartAdapter;
import com.example.ecommerce.dtos.cart.CartRequest;
import com.example.ecommerce.dtos.cart.CartResponse;
import com.example.ecommerce.dtos.general.UtilAdapter;
import com.example.ecommerce.dtos.order.OrderRequest;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.dtos.user.UserResponse;
import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.CartItem;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.CartItemRepository;
import com.example.ecommerce.repositories.CartRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.servicies.CartService;
import com.example.ecommerce.servicies.OrderService;
import com.example.ecommerce.servicies.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    CartRepository cartRepository;
    ProductRepository productRepository;
    CartItemRepository cartItemRepository;
    UserService userService;
    OrderService orderService;

    public CartServiceImpl(
            CartRepository cartRepository,
            ProductRepository productRepository,
            CartItemRepository cartItemRepository,
            UserService userService,
            OrderService orderService
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.orderService = orderService;
    }

    @Override
    public CartResponse save(CartRequest cartRequest) throws Exception {
        // find user
        User user = this.userService.findById(cartRequest.userId());
        if (user == null) return null;

        // find product
        Product product = this.productRepository.findById(cartRequest.productId()).orElse(null);
        if (product == null) return null;

        // get cart or create new one
        Cart cart = this.cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            this.cartRepository.save(newCart);
            return newCart;
        });

        // update user if it has no cart
        if (user.getCart() == null) {
            user.setCart(cart);
            this.userService.updateUser(user);
        }

        // calculate price
        Double itemPrice = product.getUnitPrice() * cartRequest.quantity();
        CartItem cartItem = this.cartItemRepository.save(new CartItem(product, cart, cartRequest.quantity(), itemPrice));

        cart.getItems().add(cartItem);

        Cart savedCart = this.cartRepository.save(cart);

        return CartAdapter.getCartResponseFromCart(savedCart);
    }

    @Override
    public CartResponse findAByUserId(Long userId) {
        User user = this.userService.findById(userId);
        if (user == null) return null;

        Cart cart = this.cartRepository.findByUser(user).orElseGet(
                () -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return this.cartRepository.save(newCart);
                }
        );

        return CartAdapter.getCartResponseFromCart(cart);
    }

    @Override
    public void deleteByUserId(Long userId) {
        User user = this.userService.findById(userId);
        if (user == null) return;

        this.cartRepository.deleteById(user.getCart().getId());
    }

    @Override
    public CartResponse orderCartItems(Long userId) {
        // find user
        UserResponse user = this.userService.getUser(userId);
        if (user == null) return null;

        // validate if user cart is not empty
        CartResponse cartResponse = user.cart();
        if (cartResponse == null || cartResponse.items() == null || cartResponse.items().isEmpty()) {
            return null;
        }

        // prepare cart items to order
        List<OrderItemRequest> orderItemRequests = UtilAdapter.getOrderItemFromCartItem(cartResponse.items());
        OrderRequest orderRequest = new OrderRequest(userId, orderItemRequests);

        OrderResponse ors = this.orderService.save(orderRequest);

        // reset cart's cart_item to empty
        Cart cart = this.cartRepository.findByUserId(user.id()).orElse(null);
        cart.setItems(new ArrayList<>());
        cart = this.cartRepository.save(cart);

        return CartAdapter.getCartResponseFromCart(cart);
    }
}
