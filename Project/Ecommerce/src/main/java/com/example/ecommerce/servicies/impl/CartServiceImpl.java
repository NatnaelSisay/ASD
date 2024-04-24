package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.cart.CartAdapter;
import com.example.ecommerce.dtos.cart.CartRequest;
import com.example.ecommerce.dtos.cart.CartResponse;
import com.example.ecommerce.models.Cart;
import com.example.ecommerce.models.CartItem;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.CartItemRepository;
import com.example.ecommerce.repositories.CartRepository;
import com.example.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.servicies.CartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    CartRepository cartRepository;
    UserRepository userRepository;
    ProductRepository productRepository;
    CartItemRepository cartItemRepository;

    public CartServiceImpl(
            CartRepository cartRepository,
            UserRepository userRepository,
            ProductRepository productRepository,
            CartItemRepository cartItemRepository
    ) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartResponse save(CartRequest cartRequest) throws Exception {
        User user = this.userRepository.findById(cartRequest.userId()).orElseThrow(() -> new Exception("user not found"));
        Product product = this.productRepository.findById(cartRequest.productId()).orElseThrow(() -> new Exception("Product not found"));

        Cart cart = this.cartRepository.findByUser(user).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            this.cartRepository.save(newCart);
            return newCart;
        });

        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }

        Double itemPrice = product.getUnitPrice() * cartRequest.quantity();
        CartItem cartItem = this.cartItemRepository.save(new CartItem(product, cart, cartRequest.quantity(), itemPrice));

        cart.getItems().add(cartItem);

        Cart savedCart = this.cartRepository.save(cart);

        return CartAdapter.getCartResponseFromCart(savedCart);
    }

    @Override
    public CartResponse findAByUserId(Long userId) {
        User user = this.userRepository.findById(userId).orElse(null);
        if (user == null) return null;
//        handle invalid user
        Cart cart = this.cartRepository.findByUser(user).orElseGet(
                () -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return this.cartRepository.save(newCart);
                }
        );

        return CartAdapter.getCartResponseFromCart(cart);
    }
}
