package com.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "recipes") // Explicitly naming the table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(columnDefinition = "TEXT") // For potentially long text
    private String ingredients;

    @Column(columnDefinition = "TEXT") // For potentially long text
    private String instructions;

    private String nutritionalInfo;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}