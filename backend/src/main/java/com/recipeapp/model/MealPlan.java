package com.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "meal_plans") // Explicitly naming the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealPlan {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate date;

    @ElementCollection
    @CollectionTable(name = "meal_plan_recipes", joinColumns = @JoinColumn(name = "meal_plan_id"))
    @Column(name = "recipe_id")
    private List<Long> recipeIds; // List of recipe IDs in the meal plan

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}