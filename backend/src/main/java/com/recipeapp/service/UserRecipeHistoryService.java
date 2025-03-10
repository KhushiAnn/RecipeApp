package com.recipeapp.service;

import com.recipeapp.exception.ResourceNotFoundException;
import com.recipeapp.model.UserRecipeHistory;
import com.recipeapp.repository.UserRecipeHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserRecipeHistoryService {

    private final UserRecipeHistoryRepository userRecipeHistoryRepository;

    @Autowired
    public UserRecipeHistoryService(UserRecipeHistoryRepository userRecipeHistoryRepository){
        this.userRecipeHistoryRepository=userRecipeHistoryRepository;
    }
    public UserRecipeHistory addRecipeHistory(UserRecipeHistory userRecipeHistory) {
        return userRecipeHistoryRepository.save(userRecipeHistory);
    }

    public UserRecipeHistory getRecipeHistoryById(Long id) {
        return userRecipeHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe history not found with id: " + id));
    }

    public List<UserRecipeHistory> getAllRecipeHistories() {
        return userRecipeHistoryRepository.findAll();
    }

    public void deleteRecipeHistory(Long id) {
        if (!userRecipeHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recipe history not found with id: " + id);
        }
        userRecipeHistoryRepository.deleteById(id);
    }

    public UserRecipeHistory updateRecipeHistory(UserRecipeHistory userRecipeHistory) {
        if (!userRecipeHistoryRepository.existsById(userRecipeHistory.getId())) {
            throw new ResourceNotFoundException("Recipe history not found with id: " + userRecipeHistory.getId());
        }
        return userRecipeHistoryRepository.save(userRecipeHistory);
    }
}