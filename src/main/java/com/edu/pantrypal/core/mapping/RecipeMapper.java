package com.edu.pantrypal.core.mapping;

import com.edu.pantrypal.core.model.Recipe;
import com.edu.pantrypal.rest.dto.RecipeDTO;

import java.util.ArrayList;

public class RecipeMapper {

    public static RecipeDTO toDTO(Recipe recipe){
        if (recipe == null){
            return null;
        }

        RecipeDTO dto = new RecipeDTO();
        dto.setRecipeId(recipe.getRecipeId());
        dto.setCookingTime(recipe.getCookingTime());
        dto.setCuisineType(recipe.getCuisineType());
        dto.setDietaryPreferences(recipe.getDietaryPreferences());
        dto.setDifficultyLevel(recipe.getDifficultyLevel());
        dto.setRecipeName(recipe.getRecipeName());
        dto.setPreparationSteps(recipe.getPreparationSteps());

        return dto;
    }

    public static Recipe toEntity(RecipeDTO dto){
        if (dto == null){
            return null;
        }

        Recipe recipe = new Recipe();
        recipe.setCookingTime(dto.getCookingTime());
        recipe.setCuisineType(dto.getCuisineType());
        recipe.setDietaryPreferences(dto.getDietaryPreferences());
        recipe.setDifficultyLevel(dto.getDifficultyLevel());
        recipe.setRatings(new ArrayList<>());
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setPreparationSteps(dto.getPreparationSteps());

        return recipe;
    }
}
