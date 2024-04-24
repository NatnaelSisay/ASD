package com.example.ecommerce.servicies;

import com.example.ecommerce.dtos.user.UserRequest;
import com.example.ecommerce.dtos.user.UserResponse;
import com.example.ecommerce.models.User;

public interface UserService {
    UserResponse getUser(Long userId);
    User findById(Long userId);
    UserResponse updateUser(User user);
    UserResponse updateUser(UserRequest user);

}
