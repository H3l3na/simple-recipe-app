package src.main.java.com.edu.pantrypal.rest.dto;

public class RatingDTO {

    private Long recipeId;
    private int stars;
    private String review;

    public RatingDTO() {}

    public RatingDTO(Long recipeId, int stars, String review) {
        this.recipeId = recipeId;
        this.stars = stars;
        this.review = review;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

