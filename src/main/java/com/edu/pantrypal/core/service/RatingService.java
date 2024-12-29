package src.main.java.com.edu.pantrypal.core.service;

import org.springframework.stereotype.Service;
import src.main.java.com.edu.pantrypal.core.mapping.RatingMapper;
import src.main.java.com.edu.pantrypal.core.model.Rating;
import src.main.java.com.edu.pantrypal.core.repository.RatingRepository;
import src.main.java.com.edu.pantrypal.rest.dto.RatingDTO;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatingsByRecipe(Long recipeId) {
        return ratingRepository.findByRecipeId(recipeId);
    }

    public Rating addRating(RatingDTO dto) {
        Rating rating = RatingMapper.toEntity(dto);
        ratingRepository.save(rating);

        return rating;
    }
}
