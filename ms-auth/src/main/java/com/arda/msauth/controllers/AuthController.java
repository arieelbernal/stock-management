package com.arda.msauth.controllers;

import com.arda.msauth.dtos.UserLoginDto;
import com.arda.msauth.dtos.UserRegisterDto;
import com.arda.msauth.models.AuthResponse;
import com.arda.msauth.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserLoginDto request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterDto request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
