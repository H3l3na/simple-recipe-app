package com.edu.pantrypal.core.service;

import com.edu.pantrypal.core.model.Recipe;
import com.edu.pantrypal.core.model.User;
import com.edu.pantrypal.core.repository.IngredientRepository;
import com.edu.pantrypal.core.repository.RatingRepository;
import com.edu.pantrypal.core.repository.RecipeRepository;
import com.edu.pantrypal.core.repository.UserRepository;
import com.edu.pantrypal.rest.dto.RecipeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private IngredientRepository ingredientRepository;

    @Mock
    private RatingRepository ratingRepository;

    @InjectMocks
    private RecipeService recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRecipes() {
        // Given
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        recipe.setRatings(new ArrayList<>());
        when(recipeRepository.findAll()).thenReturn(List.of(recipe));
        when(ingredientRepository.findByRecipeId(1L)).thenReturn(Collections.emptyList());
        when(ratingRepository.findByRecipeId(1L)).thenReturn(Collections.emptyList());

        // When
        List<RecipeDTO> recipes = recipeService.getAllRecipes();

        // Then
        assertNotNull(recipes);
        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
        verify(ingredientRepository, times(1)).findByRecipeId(1L);
    }

    @Test
    void testGetRecipeById() {
        // Given
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        recipe.setRatings(new ArrayList<>());
        when(recipeRepository.findByRecipeId(1L)).thenReturn(recipe);
        when(ingredientRepository.findByRecipeId(1L)).thenReturn(Collections.emptyList());
        when(ratingRepository.findByRecipeId(1L)).thenReturn(Collections.emptyList());

        // When
        RecipeDTO recipeDTO = recipeService.getRecipeById(1L);

        // Then
        assertNotNull(recipeDTO);
        verify(recipeRepository, times(1)).findByRecipeId(1L);
        verify(ingredientRepository, times(1)).findByRecipeId(1L);
    }

    @Test
    void testFetchMyRecipes() {
        // Given
        Long userId = 1L;
        User user = new User();
        Recipe recipe = new Recipe();
        user.setFavoriteRecipes(List.of(recipe));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // When
        List<Recipe> favoriteRecipes = recipeService.fetchMyRecipes(userId);

        // Then
        assertNotNull(favoriteRecipes);
        assertEquals(1, favoriteRecipes.size());
        assertEquals(recipe, favoriteRecipes.get(0));
        verify(userRepository, times(1)).findById(userId);
    }
}

