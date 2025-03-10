// com.recipeapp.backend.controller.UserRecipeHistoryController.java
package com.recipeapp.controller;

import com.recipeapp.model.UserRecipeHistory;
import com.recipeapp.service.UserRecipeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/userrecipehistory")
public class UserRecipeHistoryController {

    private final UserRecipeHistoryService userRecipeHistoryService;

    @Autowired
    public UserRecipeHistoryController(UserRecipeHistoryService userRecipeHistoryService){
        this.userRecipeHistoryService= userRecipeHistoryService;
    }
    @PostMapping
    public ResponseEntity<UserRecipeHistory> addRecipeHistory(@Valid @RequestBody UserRecipeHistory userRecipeHistory) {
        return new ResponseEntity<>(userRecipeHistoryService.addRecipeHistory(userRecipeHistory), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecipeHistory> getRecipeHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(userRecipeHistoryService.getRecipeHistoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserRecipeHistory>> getAllRecipeHistories() {
        return ResponseEntity.ok(userRecipeHistoryService.getAllRecipeHistories());
    }

    @PutMapping
    public ResponseEntity<UserRecipeHistory> updateRecipeHistory(@Valid @RequestBody UserRecipeHistory userRecipeHistory) {
        return ResponseEntity.ok(userRecipeHistoryService.updateRecipeHistory(userRecipeHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeHistory(@PathVariable Long id) {
        userRecipeHistoryService.deleteRecipeHistory(id);
        return ResponseEntity.noContent().build();
    }
}