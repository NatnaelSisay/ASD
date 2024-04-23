package com.example.dentalappointment.security;

import com.example.dentalappointment.security.models.LoginRequest;
import com.example.dentalappointment.security.models.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    LoginService loginService;

    public AuthController(
            LoginService loginService
    ) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest loginRequest
    ) {
        LoginResponse response = this.loginService.login(loginRequest);
        return ResponseEntity.ok(response);
    }
}
