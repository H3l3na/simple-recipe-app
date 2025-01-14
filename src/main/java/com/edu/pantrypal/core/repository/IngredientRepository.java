package com.edu.pantrypal.core.repository;

import com.edu.pantrypal.core.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecipeId(Long recipeId);
    Ingredient save(Ingredient ingredient);
}
