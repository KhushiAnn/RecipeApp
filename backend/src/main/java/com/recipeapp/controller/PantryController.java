// com.recipeapp.backend.controller.PantryController.java
package com.recipeapp.controller;

import com.recipeapp.model.Pantry;
import com.recipeapp.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pantry")

public class PantryController {

    private final PantryService pantryService;

    @Autowired
    public PantryController(PantryService pantryService){
        this.pantryService=pantryService;
    }
    @PostMapping
    public ResponseEntity<Pantry> addToPantry(@Valid @RequestBody Pantry pantry) {
        return new ResponseEntity<>(pantryService.addToPantry(pantry), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pantry> getPantryItemById(@PathVariable Long id) {
        return ResponseEntity.ok(pantryService.getPantryItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<Pantry>> getAllPantryItems() {
        return ResponseEntity.ok(pantryService.getAllPantryItems());
    }

    @PutMapping
    public ResponseEntity<Pantry> updatePantryItem(@Valid @RequestBody Pantry pantry) {
        return ResponseEntity.ok(pantryService.updatePantryItem(pantry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePantryItem(@PathVariable Long id) {
        pantryService.deletePantryItem(id);
        return ResponseEntity.noContent().build();
    }
}