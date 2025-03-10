package com.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pantry") // Explicitly naming the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pantry {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}