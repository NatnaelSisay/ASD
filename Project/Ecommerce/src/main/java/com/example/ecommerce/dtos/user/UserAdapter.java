package com.example.ecommerce.dtos.user;

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
}
