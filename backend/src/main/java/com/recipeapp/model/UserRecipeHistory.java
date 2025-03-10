package com.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_recipe_history") // Explicitly naming the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRecipeHistory {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private int rating;
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}