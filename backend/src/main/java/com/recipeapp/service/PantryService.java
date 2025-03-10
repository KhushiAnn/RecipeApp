package com.recipeapp.service;

import com.recipeapp.exception.ResourceNotFoundException;
import com.recipeapp.model.Pantry;
import com.recipeapp.repository.PantryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PantryService {

    private final PantryRepository pantryRepository;

    @Autowired
    public PantryService(PantryRepository pantryRepository){
        this.pantryRepository=pantryRepository;
    }
    public Pantry addToPantry(Pantry pantry) {
        return pantryRepository.save(pantry);
    }

    public Pantry getPantryItemById(Long id) {
        return pantryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pantry item not found with id: " + id));
    }

    public List<Pantry> getAllPantryItems() {
        return pantryRepository.findAll();
    }

    public void deletePantryItem(Long id) {
        if (!pantryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pantry item not found with id: " + id);
        }
        pantryRepository.deleteById(id);
    }

    public Pantry updatePantryItem(Pantry pantry) {
        if (!pantryRepository.existsById(pantry.getId())) {
            throw new ResourceNotFoundException("Pantry item not found with id: " + pantry.getId());
        }
        return pantryRepository.save(pantry);
    }
}