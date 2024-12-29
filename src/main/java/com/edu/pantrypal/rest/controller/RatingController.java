package src.main.java.com.edu.pantrypal.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.edu.pantrypal.core.model.Rating;
import src.main.java.com.edu.pantrypal.core.service.RatingService;
import src.main.java.com.edu.pantrypal.rest.dto.RatingDTO;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody RatingDTO ratingDTO) {
        return ResponseEntity.ok(ratingService.addRating(ratingDTO));
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<List<Rating>> getRatingsByRecipe(@PathVariable Long recipeId) {
        return ResponseEntity.ok(ratingService.getRatingsByRecipe(recipeId));
    }
}
