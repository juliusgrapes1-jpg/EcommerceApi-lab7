package com.ws101.Ubas.EcommerceApi.controller;

import com.ws101.Ubas.EcommerceApi.model.User;
import com.ws101.Ubas.EcommerceApi.service.UserService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserService userService; // Use the User service!

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) { 
        userService.saveUser(user); 
        return ResponseEntity.ok("User registered successfully! Now you can log in.");
    }
    
    @GetMapping("/me")
    public String checkIdentity() {
        return "Authentication is working! You are logged in.";
    }
}