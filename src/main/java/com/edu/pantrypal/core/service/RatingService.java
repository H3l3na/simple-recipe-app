package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.model.Recipe;
import src.main.java.com.edu.pantrypal.core.repository.RatingRepository;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Recipe> getRatingsByRecipe(Long recipeId) {
        return ratingRepository.findByRecipeId(recipeId);
    }
}
