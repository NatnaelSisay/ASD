package com.example.ecommerce.controllers;

import com.example.ecommerce.dtos.ResponseData;
import com.example.ecommerce.dtos.ResponseDataList;
import com.example.ecommerce.dtos.user.UserDTO;
import com.example.ecommerce.dtos.user.UserRequest;
import com.example.ecommerce.security.AuthRequest;
import com.example.ecommerce.security.AuthResponse;
import com.example.ecommerce.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<ResponseDataList> findAll() {
        List<UserDTO> userDTOS = this.authService.findAll();
        return ResponseEntity.ok(new ResponseDataList(userDTOS));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseData> signup(
            @RequestBody UserRequest userRequest
    ) {
        UserDTO userDTO = this.authService.signup(userRequest);
        return ResponseEntity.ok(new ResponseData(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(
            @RequestBody AuthRequest authRequest
    ) {
        AuthResponse authResponse = this.authService.login(authRequest);
        return ResponseEntity.ok(new ResponseData(authResponse));
    }
}
