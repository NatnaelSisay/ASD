package com.example.ecommerce.security;

import com.example.ecommerce.dtos.user.UserAdapter;
import com.example.ecommerce.dtos.user.UserDTO;
import com.example.ecommerce.dtos.user.UserDetail;
import com.example.ecommerce.dtos.user.UserRequest;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthService {
    UserRepository userRepository;
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;
    PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;

    }

    public UserDTO signup(UserRequest userRequest) {
        User user = UserAdapter.getUserFromRequest(userRequest);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user = this.userRepository.save(user);

        return UserAdapter.getUserDTOFromUser(user);
    }

    public List<UserDTO> findAll() {
        List<User> users = this.userRepository.findAll();
        return UserAdapter.getUserDTOListFromUser(users);
    }

    public AuthResponse login(AuthRequest loginRequest) {
        Authentication auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        if (auth.isAuthenticated()) {
            UserDetail user = (UserDetail) auth.getPrincipal();
            String token = jwtUtil.getToken(user.getEmail());
            return new AuthResponse(token, user.getFirstName(), user.getLastName(), user.getEmail());
        }

        return null;
    }
}
