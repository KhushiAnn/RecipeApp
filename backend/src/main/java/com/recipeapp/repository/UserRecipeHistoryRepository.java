package com.recipeapp.repository;

import com.recipeapp.model.UserRecipeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecipeHistoryRepository extends JpaRepository<UserRecipeHistory, Long> {
}