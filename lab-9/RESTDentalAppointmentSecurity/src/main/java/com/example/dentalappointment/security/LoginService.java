package com.example.dentalappointment.security;

import com.example.dentalappointment.security.models.LoginRequest;
import com.example.dentalappointment.security.models.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    AuthenticationManager authenticationManager;

    public LoginService(
            AuthenticationManager authenticationManager
    ) {
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Authentication auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );

        if (auth.isAuthenticated()) {
            UserDetails user = (UserDetails) auth.getPrincipal();
            System.out.println(user);
            return new LoginResponse("token");
        }

        return null;
    }
}
