package com.edu.pantrypal.core.service;

import com.edu.pantrypal.core.mapping.IngredientMapper;
import com.edu.pantrypal.core.mapping.RecipeMapper;
import com.edu.pantrypal.core.model.Ingredient;
import com.edu.pantrypal.core.model.Rating;
import com.edu.pantrypal.core.model.Recipe;
import com.edu.pantrypal.core.model.User;
import com.edu.pantrypal.core.repository.IngredientRepository;
import com.edu.pantrypal.core.repository.RatingRepository;
import com.edu.pantrypal.core.repository.RecipeRepository;
import com.edu.pantrypal.core.repository.UserRepository;
import com.edu.pantrypal.rest.dto.IngredientDTO;
import com.edu.pantrypal.rest.dto.RecipeDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;
    private final RatingRepository ratingRepository;

    public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository, IngredientRepository ingredientRepository, RatingRepository ratingRepository) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.ratingRepository = ratingRepository;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<Recipe> recipes =  recipeRepository.findAll();

        return recipes.stream()
                .map(recipe -> {
                    RecipeDTO recipeDTO = RecipeMapper.toDTO(recipe);
                    mapIngredients(recipeDTO, recipe.getRecipeId());
                    mapRatingInfo(recipeDTO, recipe.getRecipeId());

                    return recipeDTO;
                })
                .collect(Collectors.toList());
    }

    public RecipeDTO getRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        RecipeDTO recipeDTO = RecipeMapper.toDTO(recipe);
        mapIngredients(recipeDTO, recipeId);
        mapRatingInfo(recipeDTO, recipeId);

        return recipeDTO;
    }

    public Recipe createRecipe(RecipeDTO dto) {
        Recipe recipe = RecipeMapper.toEntity(dto);
        Recipe createdRecipe = recipeRepository.saveAndFlush(recipe);

        List<IngredientDTO> ingredients = dto.getIngredients();
        ingredients.stream()
                .map(ingredient -> IngredientMapper.toEntity(ingredient, createdRecipe.getRecipeId()))
                .forEach(ingredientRepository::save);

        return createdRecipe;
    }

    public void deleteRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new EntityNotFoundException("Recipe not found"));

        User user = userRepository.findByUserId(1L);

        List<Recipe> favorites = user.getFavoriteRecipes();
        if (favorites.contains(recipe)) {
            favorites.remove(recipe);
            user.setFavoriteRecipes(favorites);
            userRepository.save(user); // Persist the updated user entity
        }

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

        userRepository.save(user);
    }

    public void removeFromFavorites(Long userId, Long recipeId) {
        // Find the user by userId
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the recipe by recipeId
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        // Remove the recipe from the user's list of favorite recipes
        user.getFavoriteRecipes().remove(recipe);

        userRepository.save(user);
    }

    public List<Recipe> fetchMyRecipes(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getFavoriteRecipes();
    }

    public boolean toggleFavorite(Long userId, Long recipeId) {
        User user = userRepository.findByUserId(userId);

        boolean isFavorite = user.getFavoriteRecipes()
                .stream()
                .anyMatch(recipe -> recipe.getRecipeId().equals(recipeId));

        if (isFavorite) {
            removeFromFavorites(userId, recipeId);
            return false;
        } else {
            addToFavorites(userId, recipeId);
            return true;
        }
    }

    private void mapIngredients(RecipeDTO dto, Long recipeId){
        List<Ingredient> ingredients = ingredientRepository.findByRecipeId(recipeId);
        dto.setIngredients(IngredientMapper.toDTO(ingredients));
    }

   private void mapRatingInfo(RecipeDTO dto, Long recipeId){
       List<Rating> ratings = ratingRepository.findByRecipeId(recipeId);

       dto.setNumberOfRatings(ratings.size());
       dto.setAverageRating(ratings.stream()
               .mapToDouble(Rating::getStars)
               .average()
               .orElse(0.0));
    }
}
