package src.main.java.com.edu.pantrypal.rest.dto;

import java.util.List;

public class RecipeDTO {

    private String recipeName;
    private int cookingTime;
    private String difficultyLevel;
    private String cuisineType;
    private List<String> dietaryPreferences;
    private List<IngredientDTO> ingredients;

    public RecipeDTO() {}

    public RecipeDTO(String recipeName, int cookingTime, String difficultyLevel, String cuisineType, List<String> dietaryPreferences, List<IngredientDTO> ingredients) {
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.difficultyLevel = difficultyLevel;
        this.cuisineType = cuisineType;
        this.dietaryPreferences = dietaryPreferences;
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<String> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(List<String> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}

