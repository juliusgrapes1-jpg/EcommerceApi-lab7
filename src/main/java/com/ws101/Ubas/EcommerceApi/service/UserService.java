package com.ws101.Ubas.EcommerceApi.service;
import com.ws101.Ubas.EcommerceApi.model.User;
import com.ws101.Ubas.EcommerceApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Scrambles password!
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}