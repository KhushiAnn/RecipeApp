package com.recipeapp.service;

import com.recipeapp.exception.ResourceNotFoundException;
import com.recipeapp.model.Ingredient;
import com.recipeapp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class IngredientService {

    private final IngredientRepository ingredientRepository;
    @Autowired
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository= ingredientRepository;
    }
    public Ingredient createIngredient(Ingredient ingredient) {
        if(ingredientRepository.findByName(ingredient.getName()).isPresent()){
            throw new IllegalArgumentException("Ingredient already exists");
        }
        return ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + id));
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public void deleteIngredient(Long id) {
        if (!ingredientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ingredient not found with id: " + id);
        }
        ingredientRepository.deleteById(id);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        if (!ingredientRepository.existsById(ingredient.getId())) {
            throw new ResourceNotFoundException("Ingredient not found with id: " + ingredient.getId());
        }
        return ingredientRepository.save(ingredient);
    }
}