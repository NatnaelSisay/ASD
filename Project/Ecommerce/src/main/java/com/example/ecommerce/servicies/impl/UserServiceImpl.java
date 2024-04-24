package com.example.ecommerce.servicies.impl;

import com.example.ecommerce.dtos.user.UserAdapter;
import com.example.ecommerce.dtos.user.UserRequest;
import com.example.ecommerce.dtos.user.UserResponse;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;
import com.example.ecommerce.servicies.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        UserResponse userResponse = UserAdapter.getUserResponseFromUser(user);
        return userResponse;
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public UserResponse updateUser(User user) {
        user = this.userRepository.save(user);
        return UserAdapter.getUserResponseFromUser(user);
    }

    @Override
    public UserResponse updateUser(UserRequest user) {
        User userObj = UserAdapter.getUserFromRequest(user);
        return updateUser(userObj);
    }
}
