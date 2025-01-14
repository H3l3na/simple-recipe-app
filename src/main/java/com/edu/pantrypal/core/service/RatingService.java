package com.edu.pantrypal.core.service;

import com.edu.pantrypal.core.mapping.RatingMapper;
import com.edu.pantrypal.core.model.Rating;
import com.edu.pantrypal.core.repository.RatingRepository;
import com.edu.pantrypal.rest.dto.RatingDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Rating addRating(RatingDTO dto) {
        Rating rating = RatingMapper.toEntity(dto);

        return ratingRepository.save(rating);
    }
}
