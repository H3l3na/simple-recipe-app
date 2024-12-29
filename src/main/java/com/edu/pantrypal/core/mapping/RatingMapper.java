package com.edu.pantrypal.core.mapping;

import com.edu.pantrypal.core.model.Rating;
import com.edu.pantrypal.rest.dto.RatingDTO;

public class RatingMapper {

    public static RatingDTO toDTO(Rating rating){
        if (rating == null){
            return null;
        }

        RatingDTO dto = new RatingDTO();
        dto.setRecipeId(rating.getRatingId());
        dto.setReview(rating.getReview());
        dto.setStars(rating.getStars());

        return dto;
    }

    public static Rating toEntity(RatingDTO dto){
        if (dto == null){
            return null;
        }

        Rating rating = new Rating();
        rating.setRatingId(dto.getRecipeId());
        rating.setReview(dto.getReview());
        rating.setStars(dto.getStars());

        return rating;
    }
}
