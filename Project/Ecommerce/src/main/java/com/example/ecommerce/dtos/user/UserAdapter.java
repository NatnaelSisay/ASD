package com.example.ecommerce.dtos.user;

import com.example.ecommerce.dtos.cart.CartAdapter;
import com.example.ecommerce.dtos.cart.CartResponse;
import com.example.ecommerce.dtos.order.OrderAdapter;
import com.example.ecommerce.dtos.order.OrderResponse;
import com.example.ecommerce.models.User;

import java.util.List;

public class UserAdapter {
    public static User getUserFromRequest(UserRequest userRequest) {

        User user = new User(
                userRequest.firstName(),
                userRequest.lastName(),
                userRequest.email(),
                userRequest.password(),
                userRequest.roles(),
                userRequest.address()
        );

        return user;
    }

    public static UserDTO getUserDTOFromUser(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles()
        );

        return userDTO;
    }

    public static List<UserDTO> getUserDTOListFromUser(List<User> users) {
        return users.stream()
                .map(
                        user -> getUserDTOFromUser(user)
                ).toList();
    }

    public static UserResponse getUserResponseFromUser(User user) {
        if (user == null) return null;

        CartResponse cartResponses = CartAdapter.getCartResponseFromCart(user.getCart());
        List<OrderResponse> orderResponses = OrderAdapter.getOrderResponseFromOrder(user.getOrder());

        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRoles(),
                cartResponses,
                orderResponses
        );

        return userResponse;
    }
}
