package com.recipeapp.model;

import jakarta.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.*;

@Entity
@Table(name = "users") // Explicitly naming the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username cannot be blank")
    @Column(unique = true) // Ensures uniqueness
    private String username;

    private String password; // Should be hashed in production

    @Email(message = "Invalid email format")
    @Column(unique = true) // Ensures uniqueness
    private String email;

    private String dietaryRestrictions;
    private String allergies;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}