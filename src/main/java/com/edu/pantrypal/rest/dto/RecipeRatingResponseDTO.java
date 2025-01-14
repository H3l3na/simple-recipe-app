package com.edu.pantrypal.rest.dto;

public class RecipeRatingResponseDTO {
    private double averageRating;
    private int numberOfRatings;

    public RecipeRatingResponseDTO(double averageRating, int numberOfRatings) {
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }
}
