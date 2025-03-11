package com.recipeapp.service;

import com.recipeapp.model.User;
import com.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// ... other imports ...

@Service
public class PasswordMigrationService {

    @Autowired
    private UserRepository userRepository; // Your UserRepository
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void migratePasswords() {
        List<User> users = userRepository.findAll(); // Get all users
        for (User user : users) {
            String plainPassword = user.getPassword(); // Assuming the password is plain text
            String hashedPassword = passwordEncoder.encode(plainPassword);
            user.setPassword(hashedPassword);
            userRepository.save(user);
        }
    }
}