// com.recipeapp.backend.controller.MealPlanController.java
package com.recipeapp.controller;

import com.recipeapp.model.MealPlan;
import com.recipeapp.service.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/mealplans")

public class MealPlanController {

    private final MealPlanService mealPlanService;

    @Autowired
    public MealPlanController(MealPlanService mealPlanService){
        this.mealPlanService= mealPlanService;
    }
    @PostMapping
    public ResponseEntity<MealPlan> createMealPlan(@Valid @RequestBody MealPlan mealPlan) {
        return new ResponseEntity<>(mealPlanService.createMealPlan(mealPlan), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealPlan> getMealPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(mealPlanService.getMealPlanById(id));
    }

    @GetMapping
    public ResponseEntity<List<MealPlan>> getAllMealPlans() {
        return ResponseEntity.ok(mealPlanService.getAllMealPlans());
    }

    @PutMapping
    public ResponseEntity<MealPlan> updateMealPlan(@Valid @RequestBody MealPlan mealPlan) {
        return ResponseEntity.ok(mealPlanService.updateMealPlan(mealPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMealPlan(@PathVariable Long id) {
        mealPlanService.deleteMealPlan(id);
        return ResponseEntity.noContent().build();
    }
}