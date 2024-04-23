package com.example.dentalappointment.security;

import com.example.dentalappointment.model.User;
import com.example.dentalappointment.security.models.LoginRequest;
import com.example.dentalappointment.security.models.LoginResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    public LoginService(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest loginRequest) throws JsonProcessingException {
        Authentication auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        if (auth.isAuthenticated()) {
            User user = (User) auth.getPrincipal();
            String token = jwtUtil.getToken(user.getEmail());
            return new LoginResponse(token, user.getFirstName(), user.getLastName(), user.getEmail());
        }

        return null;
    }
}
