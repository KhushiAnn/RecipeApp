package com.recipeapp.service;

import com.recipeapp.exception.ResourceNotFoundException;
import com.recipeapp.model.MealPlan;
import com.recipeapp.repository.MealPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MealPlanService {

    private final MealPlanRepository mealPlanRepository;

    @Autowired
    public MealPlanService(MealPlanRepository mealPlanRepository){
        this.mealPlanRepository=mealPlanRepository;
    }
    public MealPlan createMealPlan(MealPlan mealPlan) {
        return mealPlanRepository.save(mealPlan);
    }

    public MealPlan getMealPlanById(Long id) {
        return mealPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meal plan not found with id: " + id));
    }

    public List<MealPlan> getAllMealPlans() {
        return mealPlanRepository.findAll();
    }

    public void deleteMealPlan(Long id) {
        if (!mealPlanRepository.existsById(id)) {
            throw new ResourceNotFoundException("Meal Plan not found with id: " + id);
        }
        mealPlanRepository.deleteById(id);
    }

    public MealPlan updateMealPlan(MealPlan mealPlan) {
        if (!mealPlanRepository.existsById(mealPlan.getId())) {
            throw new ResourceNotFoundException("Meal Plan not found with id: " + mealPlan.getId());
        }
        return mealPlanRepository.save(mealPlan);
    }
}