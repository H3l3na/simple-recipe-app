package com.edu.pantrypal.core.repository;

import com.edu.pantrypal.core.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByRecipeId(Long recipeId);

    Recipe save(Recipe recipe);

    void delete(Recipe recipe);

    List<Recipe> findAll();
}

