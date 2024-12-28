package src.main.java.com.edu.pantrypal.core.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    private String recipeName;
    private int cookingTime;
    private String difficultyLevel;
    private String cuisineType;

    @ElementCollection
    private List<String> dietaryPreferences;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rating> ratings;

    // Constructor for dependency injection
    public Recipe(String recipeName, int cookingTime, String difficultyLevel, String cuisineType) {
        this.recipeName = recipeName;
        this.cookingTime = cookingTime;
        this.difficultyLevel = difficultyLevel;
        this.cuisineType = cuisineType;
    }

    // Getters and setters omitted for brevity
}