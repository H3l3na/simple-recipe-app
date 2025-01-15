package com.edu.pantrypal.rest.controller;

import com.edu.pantrypal.core.model.Rating;
import com.edu.pantrypal.core.model.Recipe;
import com.edu.pantrypal.core.service.RatingService;
import com.edu.pantrypal.core.service.RecipeService;
import com.edu.pantrypal.rest.dto.RatingDTO;
import com.edu.pantrypal.rest.dto.RecipeDTO;
import com.edu.pantrypal.rest.dto.RecipeRatingResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final RatingService ratingService;

    public RecipeController(RecipeService recipeService, RatingService ratingService) {
        this.recipeService = recipeService;
        this.ratingService = ratingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping("/create")
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        return ResponseEntity.ok(recipeService.createRecipe(recipeDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/favorite/{userId}")
    public ResponseEntity<List<Recipe>> fetchMyRecipes(@PathVariable Long userId) {
        List<Recipe> favoriteRecipes = recipeService.fetchMyRecipes(userId);
        return ResponseEntity.ok(favoriteRecipes);
    }

    @PostMapping("/rating/add")
    public ResponseEntity<RecipeRatingResponseDTO> addRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.addRating(ratingDTO);

        // Fetch updated recipe details
        List<Rating> ratings = ratingService.getRatingsByRecipe(ratingDTO.getRecipeId());

        RecipeRatingResponseDTO response = new RecipeRatingResponseDTO(
                ratings.stream()
                        .mapToDouble(Rating::getStars)
                        .average()
                        .orElse(0.0),
                ratings.size()
        );

        return ResponseEntity.ok(response);
    }
}
