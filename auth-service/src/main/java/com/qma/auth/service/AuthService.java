package com.qma.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qma.auth.dto.AuthResponse;
import com.qma.auth.dto.LoginRequest;
import com.qma.auth.dto.RegisterRequest;
import com.qma.auth.entity.UserAuth;
import com.qma.auth.repository.UserAuthRepository;

@Service
public class AuthService {

    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserAuthRepository userAuthRepository, PasswordEncoder passwordEncoder) {
        this.userAuthRepository = userAuthRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponse register(RegisterRequest request) {
        if (userAuthRepository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthResponse("User already exists");
        }

        UserAuth user = new UserAuth();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        userAuthRepository.save(user);
        return new AuthResponse("User registered successfully");
    }

    public AuthResponse login(LoginRequest request) {
        UserAuth user = userAuthRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return new AuthResponse("User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse("Invalid password");
        }

        return new AuthResponse("Login successful");
    }
}