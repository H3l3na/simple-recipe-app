package com.edu.pantrypal.rest.dto;

public class IngredientDTO {

    private String name;
    private Integer numberOfCalories;
    private String quantity;
    private Long recipeId;

    public IngredientDTO() {}

    public IngredientDTO(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getNumberOfCalories() {
        return numberOfCalories;
    }

    public void setNumberOfCalories(Integer numberOfCalories) {
        this.numberOfCalories = numberOfCalories;
    }
}

