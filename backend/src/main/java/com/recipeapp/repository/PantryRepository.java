package com.recipeapp.repository;

import com.recipeapp.model.Pantry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantryRepository extends JpaRepository<Pantry, Long> {
}