package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.model.Recipe;
import src.main.java.com.edu.pantrypal.core.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
