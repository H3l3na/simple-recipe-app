package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.mapping.RecipeMapper;
import src.main.java.com.edu.pantrypal.core.model.Recipe;
import src.main.java.com.edu.pantrypal.core.repository.RecipeRepository;
import src.main.java.com.edu.pantrypal.rest.dto.RecipeDTO;

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

    public RecipeDTO getRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        return RecipeMapper.toDTO(recipe);
    }

    public Recipe createRecipe(RecipeDTO dto) {
        Recipe recipe = RecipeMapper.toEntity(dto);

        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findByRecipeId(recipeId);

        recipeRepository.delete(recipe);
    }
}
