package com.edu.pantrypal.core.repository;

import com.edu.pantrypal.core.model.Rating;
import com.edu.pantrypal.core.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRecipeId(Long recipeId);

    Rating save(Rating rating);

}
