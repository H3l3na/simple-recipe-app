package com.edu.pantrypal.core.repository;

import com.edu.pantrypal.core.model.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class RecipeRepositoryTest {

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByRecipeId_RecipeExists() {
        // Given
        Long recipeId = 1L;
        Recipe mockRecipe = new Recipe();
        mockRecipe.setRecipeId(recipeId);
        mockRecipe.setRecipeName("Chocolate Cake");

        // Mock behavior
        when(recipeRepository.findByRecipeId(recipeId)).thenReturn(mockRecipe);

        // When
        Recipe foundRecipe = recipeRepository.findByRecipeId(recipeId);

        // Then
        assertEquals(recipeId, foundRecipe.getRecipeId(), "Recipe ID should match");
        assertEquals("Chocolate Cake", foundRecipe.getRecipeName(), "Recipe name should match");
    }

    @Test
    void testFindByRecipeId_RecipeDoesNotExist() {
        // Given
        Long recipeId = 99L;

        // Mock behavior
        when(recipeRepository.findByRecipeId(recipeId)).thenReturn(null);

        // When
        Recipe foundRecipe = recipeRepository.findByRecipeId(recipeId);

        // Then
        assertNull(foundRecipe, "Recipe should not be found");
    }

    @Test
    void testFindAll_RecipesExist() {
        // Given
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeId(1L);
        recipe1.setRecipeName("Chocolate Cake");

        Recipe recipe2 = new Recipe();
        recipe2.setRecipeId(2L);
        recipe2.setRecipeName("Pasta Salad");

        List<Recipe> mockRecipes = new ArrayList<>();
        mockRecipes.add(recipe1);
        mockRecipes.add(recipe2);

        // Mock behavior
        when(recipeRepository.findAll()).thenReturn(mockRecipes);

        // When
        List<Recipe> recipes = recipeRepository.findAll();

        // Then
        assertEquals(2, recipes.size(), "Number of recipes should match");
        assertEquals("Chocolate Cake", recipes.get(0).getRecipeName(), "First recipe name should match");
        assertEquals("Pasta Salad", recipes.get(1).getRecipeName(), "Second recipe name should match");
    }

    @Test
    void testFindAll_NoRecipesExist() {
        // Given
        List<Recipe> mockRecipes = new ArrayList<>();

        // Mock behavior
        when(recipeRepository.findAll()).thenReturn(mockRecipes);

        // When
        List<Recipe> recipes = recipeRepository.findAll();

        // Then
        assertEquals(0, recipes.size(), "Number of recipes should be zero");
    }

    @Test
    void testSaveRecipe() {
        // Given
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);
        recipe.setRecipeName("Chocolate Cake");

        // Mock behavior
        when(recipeRepository.save(recipe)).thenReturn(recipe);

        // When
        Recipe savedRecipe = recipeRepository.save(recipe);

        // Then
        assertEquals(recipe, savedRecipe, "Saved recipe should match the original");
    }

    @Test
    void testDeleteRecipe() {
        // Given
        Recipe recipe = new Recipe();
        recipe.setRecipeId(1L);

        // No specific assertions for delete since it has no return
        recipeRepository.delete(recipe);
    }
}
