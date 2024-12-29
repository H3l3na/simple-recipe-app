package com.edu.pantrypal.core.service;

import com.edu.pantrypal.core.mapping.RecipeMapper;
import com.edu.pantrypal.core.model.Recipe;
import com.edu.pantrypal.core.model.User;
import com.edu.pantrypal.core.repository.RecipeRepository;
import com.edu.pantrypal.core.repository.UserRepository;
import com.edu.pantrypal.rest.dto.RecipeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public RecipeDTO getRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        return RecipeMapper.toDTO(recipe);
    }

    public Recipe createRecipe(RecipeDTO dto) {
        Recipe recipe = RecipeMapper.toEntity(dto);

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        recipeRepository.delete(recipe);
    }

    public void addToFavorites(Long userId, Long recipeId) {
        // Find the user by userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the recipe by recipeId
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        // Add the recipe to the user's list of favorite recipes
        user.getFavoriteRecipes().add(recipe);

        // Save the updated user with the new favorite recipe
        userRepository.save(user);
    }

    public List<Recipe> fetchMyRecipes(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getFavoriteRecipes();
    }
}
