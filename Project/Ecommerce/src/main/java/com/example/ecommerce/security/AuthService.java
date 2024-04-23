package com.example.ecommerce.security;

import com.example.ecommerce.dtos.user.UserAdapter;
import com.example.ecommerce.dtos.user.UserDTO;
import com.example.ecommerce.dtos.user.UserRequest;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthService {
    UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO signup(UserRequest userRequest) {
        User user = UserAdapter.getUserFromRequest(userRequest);
        user = this.userRepository.save(user);

        return UserAdapter.getUserDTOFromUser(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = this.userRepository.findAll();
        return UserAdapter.getUserDTOListFromUser(users);
    }
}
